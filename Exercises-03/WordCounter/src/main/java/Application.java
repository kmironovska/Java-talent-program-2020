import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        String textFromFIle = FileUtils.readFileToString(file, "UTF-8");
        textFromFIle = textFromFIle.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String words[] = textFromFIle.split(" ");

        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }

        System.out.println(textFromFIle + " " + wordsCount);

    }
}

