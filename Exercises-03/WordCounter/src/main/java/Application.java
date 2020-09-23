import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        String textFromFIle = FileUtils.readFileToString(file, "UTF-8");
        textFromFIle = textFromFIle.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String words[] = textFromFIle.split(" ");
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
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

