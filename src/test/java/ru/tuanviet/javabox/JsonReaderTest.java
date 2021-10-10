package ru.tuanviet.javabox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReaderTest {

    public String getResponseFromJsonFileTest(String fileName) throws IOException {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();
        }

        return line;

    }


}
