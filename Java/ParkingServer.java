
package Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ParkingServer {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {

            System.out.println("Parking Server started...");
            System.out.println("Waiting for client...");

            try (Socket client = server.accept();
                 BufferedReader reader = new BufferedReader(
                     new InputStreamReader(client.getInputStream()))) {

                String message = reader.readLine();

                System.out.println("Message received: " + message);
            }

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
