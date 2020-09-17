import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class CommpressionWithZip implements Archiver {
    public void archiver(File directory, File archive) throws IOException {
        FileOutputStream fis = new FileOutputStream(archive);
        ZipOutputStream zis = new ZipOutputStream(fis);
        File[] files = directory.listFiles();
        for(File file : files){
            zis.putNextEntry(new ZipEntry(new File(String.valueOf(file)).getName()));
            zis.write(FileUtils.readFileToByteArray(file));
            zis.closeEntry();

        }
        zis.close();

    }
}


