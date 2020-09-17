import java.io.File;
import java.io.IOException;

public interface Archiver {

    abstract void archiver(File directory, File archive) throws IOException;
}
