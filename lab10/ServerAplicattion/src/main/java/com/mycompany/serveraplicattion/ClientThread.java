//
//package com.mycompany.serveraplicattion;
//
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//public class ClientThread extends Thread {
//    private Socket socket;
//    private ServerAplicattion server;
//
//    public ClientThread(Socket socket, ServerAplicattion server) {
//        this.socket = socket;
//        this.server = server;
//    }
//
//    public void run() {
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                if ("stop".equalsIgnoreCase(inputLine)) {
//                    System.out.println("Server stopping now...");
//                    server.stopServer();
//                    break;
//                }
//                System.out.println("Server received the request: " + inputLine);
//            }
//        } catch (IOException e) {
//            System.out.println("Exception caught while listening for connections: " + e.getMessage());
//        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                System.out.println("Error closing client socket: " + e.getMessage());
//            }
//        }
//    }
//}
//
