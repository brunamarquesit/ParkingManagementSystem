
package Java;

import java.io.PrintWriter;
import java.net.Socket;

public class ParkingClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter writer = new PrintWriter(
                 socket.getOutputStream(), true)) {

            writer.println("Vehicle CAR456 entered the parking lot");

            System.out.println("Message sent to server.");

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
