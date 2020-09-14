import java.io.Console;
import java.util.Scanner;

public class Application extends Adress {

    public static void main(String[] args) {

        System.out.println("enter the adress in the format : StreetName streetNumber City PostalCode");
        Scanner scan = new Scanner(System.in);
        String street = scan.next();
        int streetNumber = scan.nextInt();
        String city = scan.next();
        int zipCode = scan.nextInt();
        try {
            Adress newAdress = new Adress();
            newAdress.setStreet(street);
            newAdress.setStreetNumber(streetNumber);
            newAdress.setCity(city);
            newAdress.setZipCode(zipCode);

            System.out.println(newAdress.getStreet());
            System.out.println(newAdress.getStreetNumber());
            System.out.println(newAdress.getCity());
            System.out.println(newAdress.getZipCode());

        } catch (Exception e) {
            System.out.println("Error occured" + e);
        }
    }
}
