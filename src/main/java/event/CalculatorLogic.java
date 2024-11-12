package event;

public class CalculatorLogic {
    private double currentNumber;
    private double storedNumber;
    private String currentOperator;
    private boolean newNumber;

    public CalculatorLogic() {
        clear();
    }

    public void clear() {
        currentNumber = 0;
        storedNumber = 0;
        currentOperator = "";
        newNumber = true;
    }

    public void setCurrentNumber(double number) {
        this.currentNumber = number;
    }
    public void setOperator(String operator) {
        if (!currentOperator.isEmpty()) {
            storedNumber = calculateResult();
        } else {
            storedNumber = currentNumber;
        }
        currentOperator = operator;
    }
    public void setNewNumber(boolean newNumber) {
        this.newNumber = newNumber;
    }

    public boolean isNewNumber() {
        return newNumber;
    }
    public double calculateResult() {
        switch (currentOperator) {
            case "+":
                return storedNumber + currentNumber;
            case "-":
                return  storedNumber - currentNumber;
            case "*":
                return storedNumber * currentNumber;
            case "/":
                if (currentNumber == 0) {
                    throw  new ArithmeticException("Divide by zero is not possible.");
                } else {
                    return storedNumber / currentNumber;
                }
            default:
                return currentNumber;
        }
    }
}
