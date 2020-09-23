import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");

        Scanner scan = new Scanner(System.in);
        System.out.println("Write 'asc' if you want the words to be sorted in ascending order or 'desc' if you want to be sorted in descending order");
        String choosedSortingType = scan.nextLine();
        System.out.println("Specify min length of words");
        int min = scan.nextInt();
        System.out.println("Specify max length of words");
        int max = scan.nextInt();

        Set<String> uniqueWords = new HashSet<String>();
        String textFromFile = FileUtils.readFileToString(file, "UTF-8");
        textFromFile = textFromFile.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String words[] = textFromFile.split(" ");

        for (String word : words) {
            uniqueWords.add(word);
        }
        List<String> list = new ArrayList<>(uniqueWords);
        if (choosedSortingType.toLowerCase().equals("asc")) {
            list.stream().sorted((o1, o2) -> o1.length() - o2.length()).filter(w -> max > 0 ? (w.length() >= min && w.length() <= max) : w.length() >= min).forEach(System.out::println);
        } else if (choosedSortingType.toLowerCase().equals("desc")) {
            list.stream().sorted((o1, o2) -> o2.length() - o1.length()).filter(w -> max > 0 ? (w.length() <= max) : w.length() >= min).forEach(System.out::println);
        }

    }

}
