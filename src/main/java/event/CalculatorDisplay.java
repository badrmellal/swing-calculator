package event;

import javax.swing.*;
import java.awt.*;

public class CalculatorDisplay {
    private final JTextField display;
    private final JPanel displayPanel;

    public CalculatorDisplay() {
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayPanel.add(display);
    }

    public JPanel getDisplayPanel() {
        return displayPanel;
    }
    public void clear(){
        display.setText("0");
    }
    public void setDisplay(String text) {
        display.setText(text);
    }
    public void appendToDisplay(String text) {
            display.setText(display.getText() + text);
    }

    public String getDisplay() {
        return display.getText();
    }
}
