package org.example.server;

import java.io.IOException;

public interface ILogger {
    void writeLog(String text) throws IOException;

    String readLog();
}
