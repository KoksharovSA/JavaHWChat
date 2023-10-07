package org.example;

import org.example.client.Client;
import org.example.client.Server;
import org.example.server.IServer;

public class Main {
    public static void main(String[] args) {
        IServer server = new Server();
        new Client(server);
        new Client(server);
    }
}