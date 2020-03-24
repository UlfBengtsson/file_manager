package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App 
{
    public static void main( String[] args )
    {
        try {
            printToFileWithPrintWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToFileWithPrintWriter() throws IOException {

        File file = new File("example.txt");

        boolean appendToEnd = file.exists() && file.isFile(); //file.isDirectory()

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());

        try (FileWriter fileWriter = new FileWriter(file, appendToEnd))
        {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Just some plain old text here");
            printWriter.printf("First a string %s and and then a number %d", "SAAB", 900);
            printWriter.close();
        }
    }
}
