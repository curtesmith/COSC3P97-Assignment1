package ca.brocku.cs97aa.assignment1;

import java.util.Observable;


public class CalculatorModel extends Observable {

    private Display display;
    private Number operand;
    private Operation operation;

    public CalculatorModel() {
        setOperand(null);
        setOperation(null);
        display = new Display();
    }


    private void setOperand(String operand) {
        if (operand == null) {
            this.operand = null;
            return;
        }

        Double number = Double.valueOf(operand);

        if (isAnInteger(number)) {
            this.operand = number.intValue();
        } else {
            this.operand = number;
        }
    }


    private static boolean isAnInteger(Double number) {
        return number % 1 == 0;
    }


    public Number getOperand() {
        return operand;
    }


    public void appendToDisplay(String text) {
        appendToDisplay(text, false);
    }


    public void appendToDisplay(String text, boolean replaceText) {
        if(replaceText) {
            display.setText(text);
            display.setAppendModeOff();
        } else {
            display.appendText(text);
        }

        setChanged();
        notifyObservers();
    }


    public String getDisplay() {
        return display.getText();
    }


    public void clear() {
        setOperand(null);
        setOperation(null);
        appendToDisplay("0", true);
    }


    public void addition() {
        setOperation(new Addition());
    }


    public void subtraction() {
        setOperation(new Subtraction());
    }


    public void multiplication() {
        setOperation(new Multiplication());
    }


    public void division() {
        setOperation(new Division());
    }


    private void setOperation(Operation operation) {
        if (operation == null) {
            this.operation = null;
            return;
        }

        calculate();
        setOperand(getDisplay());
        this.operation = operation;
        display.setAppendModeOff();
    }


    private Operation getOperation() {
        return operation;
    }


    public void calculate() {
        Number result;

        if(getOperation() == null) {
            return;
        }

        if (getOperand() == null) {
            setOperand(getDisplay());
            result = getOperand();
        } else {
            Number firstOperand = getOperand();
            setOperand(getDisplay());
            result = getOperation().run(firstOperand, getOperand());
        }

        setOperand(result.toString());
        appendToDisplay(result.toString(), true);
    }
}
