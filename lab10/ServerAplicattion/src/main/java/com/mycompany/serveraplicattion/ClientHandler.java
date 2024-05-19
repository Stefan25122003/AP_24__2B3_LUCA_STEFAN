
package com.mycompany.serveraplicattion;


import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                inputLine = inputLine.trim();
                System.out.println("Received from client: " + inputLine);
                if ("stop".equalsIgnoreCase(inputLine)) {
                    System.out.println("Stop command received.");
                    out.println("Server stopping now...");
                    if (this.clientSocket != null) {
                        this.clientSocket.close();
                    }
                    System.exit(0);
                }
                out.println("Echo: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing stream or socket: " + e.getMessage());
            }
        }
    }
}