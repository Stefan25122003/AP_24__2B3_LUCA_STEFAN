package com.mycompany.serveraplicattion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerAplicattion {
    private static final int PORT = 5064;
    private static final ExecutorService clientThreads = Executors.newCachedThreadPool();
    private static final Map<String, GameSession> games = new HashMap<>();
    private static final Map<String, List<ClientHandler>> gameClientHandlers = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket, games, gameClientHandlers);
                clientThreads.submit(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
