package org.example.client;

import org.example.server.IServer;

import java.io.IOException;
import java.util.UUID;

public class Client implements IClient{
    private String clientUUID;
    private IServer server;
    private IWindow clientWindow;

    public Client(IServer server) {
        clientUUID = UUID.randomUUID().toString();
        this.server = server;
        clientWindow = new ClientWindow(this);
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
        if (message != "" && message != null){
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
