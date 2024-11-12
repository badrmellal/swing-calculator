package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorKeypad {
    private final JPanel keypadPanel;
    private final String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    public CalculatorKeypad(ActionListener listener) {
        keypadPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        keypadPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(listener);
            keypadPanel.add(button);
        }
    }

    public JPanel getKeypadPanel() {
        return keypadPanel;
    }
}
