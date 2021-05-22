import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 200);

        frame.add(new MainForm().getMainPanel());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
