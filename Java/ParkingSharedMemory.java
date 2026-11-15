
package Java;

public class ParkingSharedMemory {

    static class ParkingData {
        private String lastVehicle;
        private boolean available = false;

        public synchronized void produce(String plate)
                throws InterruptedException {

            while (available) {
                wait();
            }

            lastVehicle = plate;
            available = true;

            System.out.println("Producer added: " + plate);
            notifyAll();
        }

        public synchronized String consume()
                throws InterruptedException {

            while (!available) {
                wait();
            }

            String plate = lastVehicle;
            available = false;

            notifyAll();
            return plate;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        ParkingData sharedData = new ParkingData();

        Thread producer = new Thread(() -> {
            try {
                sharedData.produce("CAR456");
                sharedData.produce("MOTO123");
                sharedData.produce("BUS789");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    String plate = sharedData.consume();
                    System.out.println(
                        "Consumer received: " + plate
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

        System.out.println("Shared Memory Test completed.");
    }
}
