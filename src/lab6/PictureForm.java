import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Парабола");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }

    public PictureForm() {
        angleSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                canvasPanel.setAngle((int)angleSpinner.getValue());
            }
        });
        pField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    canvasPanel.setP(Double.parseDouble(pField.getText()));
                } catch (NumberFormatException exc) {
                    pField.setText("Введено неверное число");
                }
            }
        });
        angleSpinner.setValue(90);
    }

    private JPanel mainPanel;
    private JSpinner angleSpinner;
    private JTextField pField;
    private CanvasPanel canvasPanel;
}
