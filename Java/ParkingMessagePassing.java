
package Java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingMessagePassing {

    public static void main(String[] args)
            throws InterruptedException {

        BlockingQueue<String> messages =
                new LinkedBlockingQueue<>();

        // Producer: sends parking information
        Thread producer = new Thread(() -> {
            try {
                messages.put("Car CAR456 entered parking");
                messages.put("Motorcycle MOTO123 entered parking");
                messages.put("Bus BUS789 entered parking");
                messages.put("END");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer: receives parking information
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String message = messages.take();

                    if (message.equals("END")) {
                        break;
                    }

                    System.out.println(
                        "Consumer received: " + message
                    );
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Message Passing Test completed.");
    }
}
