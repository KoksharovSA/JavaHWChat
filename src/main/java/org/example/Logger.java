package org.example;

import java.io.*;
import java.util.Scanner;

public class Logger {
    private final String FILE_NAME = "log.txt";

    public void writeLog(String text) throws IOException {
        FileWriter myWriter = new FileWriter(FILE_NAME);
        if (text != null && text != ""){
            myWriter.write(text);
        }
        myWriter.close();
    }

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
