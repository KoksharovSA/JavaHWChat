package org.example;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in;
    private static BufferedWriter out;

//    public Client(Socket socket) {
//        try {
//            try {
//                clientSocket = socket;
//                reader = new BufferedReader(new InputStreamReader(System.in));
//                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//
//                String word = reader.readLine();
//                out.write(word + "\n");
//                out.flush();
//                String serverWord = in.readLine();
//                System.out.println(serverWord);
//            } finally { // в любом случае необходимо закрыть сокет и потоки
//                System.out.println("Клиент был закрыт...");
//                clientSocket.close();
//                in.close();
//                out.close();
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//    }

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("127.0.0.1", 55555);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
