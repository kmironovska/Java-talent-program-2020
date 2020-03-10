import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input =new Scanner(System.in).nextLine();
        String[] splittedWords=input.split(" ");
        String result="";
        for(int i=0;i<splittedWords.length;i++){
            switch (splittedWords[i]){
                case "zero":
                    result+="0";
                    break;
                case "one":
                    result+="1";
                    break;
                case "two":
                    result+="2";
                    break;
                case "three":
                    result+="3";
                    break;
                case "four":
                    result+="4";
                    break;
                case "five":
                    result+="5";
                    break;
                case "six":
                    result+="6";
                    break;
                case "seven":
                    result+="7";
                    break;
                case "eight":
                    result+="8";
                    break;
                case "nine":
                    result+="9";
                    break;
            }

        }
        int finalResult=Integer.parseInt(result);
        System.out.println(finalResult);
    }
}
