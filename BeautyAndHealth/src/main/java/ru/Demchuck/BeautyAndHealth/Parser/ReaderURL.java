package ru.Demchuck.BeautyAndHealth.Parser;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderURL {
    private File file;
    private final String fullPath = "src/main/resources/";
    @Getter private ArrayList<String> url;

    public ReaderURL(String path) {
        path = fullPath + path;
        file = new File(path);
        url = new ArrayList<String>();
    }

    public void read() {
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader) ) {
            String str = bufferedReader.readLine();
            while (str != null) {
                url.add(str);
                str = bufferedReader.readLine();
            }
            //url.remove(url.remove(url.size() - 1));
        }catch (Exception error) {
            error.printStackTrace();
        }
    }
}
