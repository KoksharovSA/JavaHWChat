package org.example.chat.client;

import org.example.chat.server.IServer;

import java.io.IOException;
import java.util.UUID;

public class Client implements IClient {
    private final String clientUUID;
    private final IServer server;
    private final IWindow clientWindow;

    public Client(IServer server, IWindow clientWindow) {
        clientUUID = UUID.randomUUID().toString();
        this.server = server;
        this.clientWindow = clientWindow;
        clientWindow.setClientWindow(this);
    }

    @Override
    public String getClientUUID() {
        return clientUUID;
    }

    @Override
    public boolean connect() {
        if (this.server != null) {
            this.server.addClient(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean disconnect() {
        if (this.server != null) {
            this.server.deleteClient(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean sendMessage(String message) throws IOException {
        if (!message.isEmpty()) {
            server.recordMessage(message);
            return true;
        }
        return false;
    }

    @Override
    public void printMessage(String message) {
        clientWindow.printMessage(message);
    }
}
