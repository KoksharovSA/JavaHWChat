package org.example.chat;

import org.example.chat.client.Client;
import org.example.chat.client.ClientWindow;
import org.example.chat.server.Server;
import org.example.chat.server.IServer;

public class Main {
    public static void main(String[] args) {
        IServer server = new Server();
        new Client(server, new ClientWindow());
        new Client(server, new ClientWindow());
    }
}