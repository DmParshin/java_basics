import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        try {
            long size = org.apache.commons.io.FileUtils.sizeOfDirectory(new File(path));

            System.out.println("Folder Size: " + org.apache.commons.io.FileUtils.byteCountToDisplaySize(size));

            return (size);
        }
        catch (IllegalArgumentException e){
            System.out.println("Нет такой папки!");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

}