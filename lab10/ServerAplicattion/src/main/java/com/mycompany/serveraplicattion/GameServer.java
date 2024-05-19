
package com.mycompany.serveraplicattion;


import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class GameServer {
    public static void main(String[] args) throws IOException {
        ServerAplicattion server = new ServerAplicattion();
        server.startServer(6678);
    }
}
