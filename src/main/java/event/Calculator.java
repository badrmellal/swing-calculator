package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator extends JFrame {
    private final CalculatorDisplay display;
    private final CalculatorLogic logic;
    private final CalculatorKeypad keypad;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // we initialize these components
        display = new CalculatorDisplay();
        logic = new CalculatorLogic();
        keypad = new CalculatorKeypad(new ButtonClickListner());

        // next we add components to frame
        add(display.getDisplayPanel(), BorderLayout.NORTH);
        add(keypad.getKeypadPanel(), BorderLayout.CENTER);

        // next we set frame properties here
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // this is an inner class for handling button clicks
    private class ButtonClickListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            processCommand(command);
        }
    }

    private void processCommand(String command) {
        switch (command) {
            case "C":
                logic.clear();
                display.clear();
                break;
            case "=":
                try {
                    double result = logic.calculateResult();
                    display.setDisplay(String.valueOf(result));
                    logic.setNewNumber(true);
                } catch (ArithmeticException e) {
                    display.setDisplay("Error");
                    logic.clear();
                }
            break;
            case "+":
            case "-":
            case "*":
            case "/":
                        logic.setOperator(command);
                        logic.setNewNumber(true);
            break;
            default:
                if (logic.isNewNumber()) {
                    display.setDisplay(command);
                    logic.setNewNumber(false);
                } else {
                    display.appendToDisplay(command);
                }
                logic.setCurrentNumber(Double.parseDouble(display.getDisplay()));

        }
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            });
    }
}