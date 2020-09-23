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
        String textFromFile = FileUtils.readFileToString(file, "UTF-8");
        textFromFile = textFromFile.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String words[] = textFromFile.split(" ");
        Set<String> uniqueWords = new HashSet<String>();

        for (String word : words) {
            uniqueWords.add(word);
        }
        ArrayList<String> list = new ArrayList<String>(uniqueWords);

        if (choosedSortingType.toLowerCase().equals("asc")) {
            Collections.sort(list, new AscendingLengthStringComparator());
            System.out.println(list);
        } else if (choosedSortingType.toLowerCase().equals("desc")) {
            Collections.sort(list, new DescendingLengthStringComparator());
            System.out.println(list);
        }

    }
    }

