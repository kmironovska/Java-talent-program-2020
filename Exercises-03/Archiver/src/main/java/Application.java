import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        File directory = new File("files");
        System.out.println("Please specify a compression algorithm.For 7zip write : 7z, for zip write : zip");
        Scanner scan = new Scanner(System.in);
        String choosedAlgorithm = scan.nextLine();

        if (choosedAlgorithm.toLowerCase().equals("7z")) {
            SevenZipArchiver sevenZipArchiver = new SevenZipArchiver();
            File sevenZipArchiverfile = new File("archive.7z");
            sevenZipArchiver.archiver(directory, sevenZipArchiverfile);
            System.out.println("Created 7z file");
        } else if (choosedAlgorithm.toLowerCase().equals("zip")) {
            ZipArchiver zipArchiver = new ZipArchiver();
            File zipArchiverfile = new File("archive.zip");
            zipArchiver.archiver(directory, zipArchiverfile);
            System.out.println("Created zip file");
        }
    }


}

