//
//package com.mycompany.clientaplicattion;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//public class GameClient {
//     public static void main(String[] args) throws Exception {
//        String serverAddress = "127.0.0.1";
//        int PORT = 6679;
//        try (Socket socket = new Socket(serverAddress, PORT);
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
//
//            String userInput;
//            while ((userInput = stdIn.readLine()) != null) {
//                if ("exit".equalsIgnoreCase(userInput)) {
//                    break;
//                }
//                out.println(userInput);
//                System.out.println("Server says: " + in.readLine());
//            }
//        }
//    }
//}
