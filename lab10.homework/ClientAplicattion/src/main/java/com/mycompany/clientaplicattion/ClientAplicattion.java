package com.mycompany.clientaplicattion;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientAplicattion {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 5064);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                System.out.println(dis.readUTF());

                String tosend = scn.nextLine();
                dos.writeUTF(tosend);

                if (tosend.equalsIgnoreCase("exit")) {
                    System.out.println("Closing this connection: " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

                String received = dis.readUTF();
                System.out.println(received);
            }

            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
