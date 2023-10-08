package org.example;

import org.example.client.Client;
import org.example.client.ClientWindow;
import org.example.server.Server;
import org.example.server.IServer;

public class Main {
    public static void main(String[] args) {
        IServer server = new Server();
        new Client(server, new ClientWindow());
        new Client(server, new ClientWindow());
    }
}