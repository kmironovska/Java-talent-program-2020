import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Enter height of Box:");
        Integer height = new Scanner( System.in).nextInt();
        System.out.println("Enter width");
        Integer width = new Scanner( System.in).nextInt();
        System.out.println("Enter depth");
        Integer depth = new Scanner( System.in).nextInt();
        Box box = new Box(height,width,depth);
        box.volume();
    }
}
