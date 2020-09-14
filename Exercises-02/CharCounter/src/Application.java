import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Enter a sentence");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        HashMap<Character, Integer> charactersCount = new HashMap<Character, Integer>();
        char[] arrayofCharacters = sentence.toCharArray();
        for (char character : arrayofCharacters) {
            if (charactersCount.containsKey(character)) {
                charactersCount.put(character, charactersCount.get(character) + 1);
            } else {
                charactersCount.put(character, 1);
            }
        }
        System.out.println(sentence + " " + charactersCount);
    }
}
