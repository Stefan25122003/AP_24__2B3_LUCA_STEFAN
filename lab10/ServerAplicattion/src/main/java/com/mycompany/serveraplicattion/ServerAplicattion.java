
package com.mycompany.serveraplicattion;



import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServerAplicattion {
    private volatile boolean running = true;
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerAplicattion server = new ServerAplicattion();
        server.startServer(6678);
    }

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected");
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    new Thread(clientHandler).start();
                } catch (IOException e) {
                    if (!running) {
                        System.out.println("Server is stopping now...");
                    } else {
                        throw new IOException(e);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }

    public void stopServer() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error closing server socket: " + e.getMessage());
        }
    }

    public boolean isRunning() {
        return running;
    }
}