package org.example;

import java.io.*;
import java.net.Socket;

class ServerSomthing extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                for (ServerSomthing vr : Server.serverList) {
                    if (!vr.socket.isClosed()) {
                        vr.send(word);
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }
}