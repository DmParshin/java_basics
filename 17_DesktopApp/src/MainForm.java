import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel secondName;
    private JTextField secondNameField;
    private JLabel surname;
    private JTextField surnameField;
    private JTextPane textPane1;

    private final String name_surname = "[А-Я][а-я]+\\s[А-Я][а-я]+";

    public JPanel getMainPanel(){
        return mainPanel;
    }

    MainForm (){
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                if(collapseButton.getText().equals("Collapse")){
                    if (surnameField.getText().isEmpty() || firstNameField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Данные введены некорректно, введите данные",
                                "Ошибка",
                                JOptionPane.PLAIN_MESSAGE
                        );
                    }
                    else {
                        textPane1.setText(surnameField.getText() + " " + firstNameField.getText() + " " + secondNameField.getText());
                        collapseButton.setText("Expand");
                    }
                }

                else if(collapseButton.getText().equals("Expand")){
                    if(textPane1.getText().matches(name_surname)){
                        String[] fio= textPane1.getText().split("\s");
                        surnameField.setText(fio[0]);
                        firstNameField.setText(fio[1]);
                        collapseButton.setText("Collapse");
                    }
                    else {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Данные введены некорректно, введите данные",
                                "Ошибка",
                                JOptionPane.PLAIN_MESSAGE
                        );
                    }
                }
            }
        });
    }
}
