import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
            sortingAndFiltering("asc", list, min, max).forEach(System.out::println);

        } else if (choosedSortingType.toLowerCase().equals("desc")) {
            sortingAndFiltering("desc", list, min, max).forEach(System.out::println);

        }


    }

    public static List<String> sortingAndFiltering(String sortingType, List<String> list, int min, int max) {
        if (sortingType.toLowerCase().equals("asc")) {
            return list.stream().sorted((String o1, String o2) -> o1.length() - o2.length()).filter(w -> max > 0 ? (w.length() >= min && w.length() <= max) : w.length() >= min).collect(Collectors.toList());

        } else if (sortingType.toLowerCase().equals("desc")) {
            return list.stream().sorted((String o1, String o2) -> o2.length() - o1.length()).filter(w -> max > 0 ? (w.length() >= min && w.length() <= max) : w.length() >= min).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Illegal argument,type asc or desc");
        }

    }
}