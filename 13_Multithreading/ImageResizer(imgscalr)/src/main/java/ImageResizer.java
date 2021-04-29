import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizer extends Thread {

    private final File[] files;
    private final int newWidth;
    private final String dstFolder;
    private final long start;
    private int height;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start){
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start =start;
    }

    @Override
    public void run() {
        try {
            for (File file:files){
                BufferedImage image = ImageIO.read(file);
                if (image == null) { continue; }
                height = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));

                image = Scalr.resize(image,
                        Scalr.Method.ULTRA_QUALITY,
                        Scalr.Mode.FIT_EXACT,
                        newWidth,
                        height);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(image, "jpg", newFile);
                image.flush();
            }
        } catch (IllegalArgumentException | IOException e) {
                System.out.println("Resizing failed");
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}

