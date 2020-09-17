import java.io.Console;
import java.util.Scanner;

public class Application  {


    public static void main(String[] args) {

        System.out.println("enter the adress in the format : StreetName streetNumber City PostalCode");
        Scanner scan = new Scanner(System.in);
        String street = scan.next();
        int streetNumber = scan.nextInt();
        String city = scan.next();
        int zipCode = scan.nextInt();
        try {
            Adress newAdress = new Adress(street, streetNumber, city, zipCode);


            System.out.println(newAdress.toString());

        }catch (InvalidZipCodeException e) {
            e.printStackTrace();
        }
    }
}
