import java.util.Scanner;

public class DateParserApplication {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        String month = str.substring(0,2);
        String day = str.substring(3,5);
        String year = str.substring(6,10);
        System.out.println("The month is : "  + month);
        System.out.println("The day is :  " + day);
        System.out.println("The year is: " + year);
    }
}
