package org.example.server;

import org.example.client.IClient;

import java.io.IOException;

public interface IServer {
    void addClient(IClient client);
    void deleteClient(IClient client);
    void recordMessage(String message) throws IOException;
    void broadcastMessage(String message);
}
