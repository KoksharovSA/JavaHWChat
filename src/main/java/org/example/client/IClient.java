package org.example.client;

import java.io.IOException;

public interface IClient {
    String getClientUUID();
    boolean connect();
    boolean disconnect();
    boolean sendMessage(String message) throws IOException;
    void printMessage(String message);
}
