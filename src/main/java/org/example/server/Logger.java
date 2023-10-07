package org.example.server;

import java.io.*;
import java.util.Scanner;

public class Logger implements ILogger{
    private final String FILE_NAME = "log.txt";
    @Override
    public void writeLog(String text) throws IOException {
        FileWriter myWriter = new FileWriter(FILE_NAME);
        if (text != null && text != ""){
            myWriter.write(text);
        }
        myWriter.close();
    }

    @Override
    public String readLog(){
        String result = "";
        try {
            File logFile = new File(FILE_NAME);
            if (logFile.exists()){
                Scanner myReader = new Scanner(logFile);
                while (myReader.hasNextLine()) {
                    result += myReader.nextLine() + "\n";
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
