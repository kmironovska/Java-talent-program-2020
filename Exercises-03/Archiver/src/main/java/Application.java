import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {

        File directory = new File("files");
        File zipCommpresion = new File("archive.zip");
        File sevenZipCompression = new File("archive.7z");
        CommpressionWithZip zip = new CommpressionWithZip();
        CommpresionWith7z sevenZip = new CommpresionWith7z();

        System.out.println("Please specify a compression algorithm.For 7zip write : 7z, for zip write : zip");
        Scanner scan = new Scanner(System.in);
        String choosedAlgorithm = scan.nextLine();

        if (choosedAlgorithm.toLowerCase().equals("7z")) {
            sevenZip.archiver(directory, sevenZipCompression);
            System.out.println("Created 7z file");
        } else if (choosedAlgorithm.toLowerCase().equals("zip")) {
            zip.archiver(directory, zipCommpresion);
            System.out.println("Created zip file");
        }
    }


}

