
package Java;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class ParkingSharedMemoryIPC {

    private static final int SIZE = 1024;

    public static void main(String[] args) throws Exception {

        if (args.length != 1 ||
            (!args[0].equals("producer") &&
             !args[0].equals("consumer"))) {

            System.out.println(
                "Usage: java -cp . Java.ParkingSharedMemoryIPC producer|consumer"
            );
            return;
        }

        String filePath = Paths.get(
            System.getProperty("java.io.tmpdir"),
            "parking_shared_memory.dat"
        ).toString();

        try (RandomAccessFile file =
                 new RandomAccessFile(filePath, "rw");
             FileChannel channel = file.getChannel()) {

            MappedByteBuffer buffer =
                channel.map(FileChannel.MapMode.READ_WRITE, 0, SIZE);

            if (args[0].equals("producer")) {

                String message = "CAR456 entered parking";
                byte[] data = message.getBytes(StandardCharsets.UTF_8);

                buffer.putInt(0, 0);
                buffer.putInt(4, data.length);
                buffer.position(8);
                buffer.put(data);
                buffer.force();

                buffer.putInt(0, 1);
                buffer.force();

                System.out.println("Producer sent: " + message);

            } else {

                System.out.println("Consumer waiting for data...");

                long deadline = System.currentTimeMillis() + 30000;

                while (buffer.getInt(0) != 1) {
                    if (System.currentTimeMillis() > deadline) {
                        System.out.println("Timeout waiting for producer.");
                        return;
                    }
                    Thread.sleep(100);
                }

                int length = buffer.getInt(4);

                if (length < 0 || length > SIZE - 8) {
                    throw new IllegalStateException("Invalid message length");
                }

                byte[] data = new byte[length];
                buffer.position(8);
                buffer.get(data);

                String message =
                    new String(data, StandardCharsets.UTF_8);

                System.out.println("Consumer received: " + message);

                buffer.putInt(0, 0);
                buffer.force();
            }
        }

        System.out.println("Shared Memory IPC completed.");
    }
}
