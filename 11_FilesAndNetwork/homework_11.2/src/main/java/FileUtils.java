import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File srcdir = new File(sourceDirectory);
        File dstdir = new File(destinationDirectory);
        org.apache.commons.io.FileUtils.copyDirectory(srcdir, dstdir);

    }
}
