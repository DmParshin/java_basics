import java.io.File;

public class Main {

    private static final int NEW_WIDTH = 300;
    private static final String SRC_FOLDER = "images/src";
    private static final String DST_FOLDER = "images/dst";

    public static void main(String[] args) {

        File srcDir = new File(SRC_FOLDER);
        File[] files = srcDir.listFiles();

        long start = System.currentTimeMillis();

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Число процессоров: " + processors);
        System.out.println("Количество файлов " + files.length);

        int[] filesToThreads = new int[processors];
        int remainder = files.length  % processors;
        for(int i = 0; i < processors; i++){
            filesToThreads[i] = files.length / processors;
            if (remainder > 0) {
                filesToThreads[i]++;
                remainder--;
            }
        }

        int srcPos = 0;
        for(int i = 0; i < filesToThreads.length; i++) {
            File[] files1 = new File[filesToThreads[i]];
            System.arraycopy(files, srcPos, files1, 0, filesToThreads[i]);
            ImageResizer imageResizer = new ImageResizer(files1,NEW_WIDTH,DST_FOLDER,start);
            imageResizer.start();
            srcPos = srcPos + filesToThreads[i];
        }
    }
}
