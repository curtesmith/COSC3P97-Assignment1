package ca.brocku.cs97aa.assignment1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;


public class CalculatorModel extends Observable implements Observer {

    private Display display;
    private Number operand;
    private Operation operation;
    private String toastMessage;
    private boolean displayHasChanged;

    public CalculatorModel() {
        setOperand(null);
        setOperation(null);
        display = new Display();
        setMessage(null);
        displayHasChanged = false;
        display.addObserver(this);
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


    public void appendToDisplay(Number number, boolean replaceNumber) {
        String text;

        if (number.doubleValue() > 999999999) {
            text = formatNumber(number);
        } else {
            text = number.toString();
        }

        appendToDisplay(text, replaceNumber);
    }


    private String formatNumber(Number number) {
        NumberFormat formatter = new DecimalFormat("0.####E0");
        return formatter.format(number.doubleValue());
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
        } else if (displayHasChanged) {
            try {
                Number firstOperand = getOperand();
                setOperand(getDisplay());
                result = getOperation().run(firstOperand, getOperand());
                setOperation(null);
                setOperand(null);
                appendToDisplay(result, true);
                displayHasChanged = false;
            } catch (Exception ex) {
                setMessage(ex.getMessage());
                setChanged();
                notifyObservers();
            }
        }


    }


    public String getMessage() {
        return toastMessage;
    }


    public void setMessage(String message) {
        if(message == null) {
            toastMessage = null;
        } else {
            toastMessage = message;
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        displayHasChanged = true;
    }
}
