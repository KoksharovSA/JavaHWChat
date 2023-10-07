package org.example.server;

import org.example.client.IClient;
import org.example.server.IServer;
import org.example.server.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server implements IServer {
    private List<IClient> clients;
    private String messages;
    private ILogger logger;
    public Server() {
        clients = new ArrayList<>();
        logger = new Logger();
        messages = logger.readLog();
    }

    @Override
    public void recordMessage(String message) throws IOException {
        messages += message;
        logger.writeLog(messages);
        broadcastMessage(message);
    }

    @Override
    public void broadcastMessage(String message) {
        for (IClient cli: this.clients) {
            cli.printMessage(message);
        }
    }

    @Override
    public void addClient(IClient client) {
        if (client != null) {
            clients.add(client);
            System.out.println("Подключился клиент (" + client.getClientUUID() + ")");
            client.printMessage(messages);
        }
    }

    @Override
    public void deleteClient(IClient client) {
        this.clients.remove(client);
        System.out.println("Отключился клиент (" + client.getClientUUID() + ")");
    }
}
