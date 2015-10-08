package ca.brocku.cs97aa.assignment1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * The main logic of the calculator application it contains the methods
 * that perform the arithmetic calculations as well as formats and updates the display
 * to the user.
 */
public class CalculatorModel extends Observable implements Observer {

    private Display display;
    private Number operand;
    private Operation operation;
    private String toastMessage;
    private boolean displayHasChanged;


    /**
     * Constructor that sets up a new instance of the class and assigns default
     * values to its members
     */
    public CalculatorModel() {
        setOperand(null);
        setOperation(null);
        display = new Display();
        setMessage(null);
        displayHasChanged = false;
        display.addObserver(this);
    }


    /**
     * Save one of the operands intended by the user to be included in the
     * calculation operation. Bu default the number will be stored as a double
     * but if the number is an integer it will be stored as an integer.
     *
     * @param operand is a string representation of the number submitted by
     *                the user for the calculation
     */
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


    /**
     * Check to see if the number passed in the parameter is evenly divisible by a
     * factor of 1 and if so then it is an integer
     *
     * @param number is a number that will be checked to confirm if it is an integer
     * @return true if the number is an integer otherwise return false
     */
    private static boolean isAnInteger(Double number) {
        return number % 1 == 0;
    }


    /**
     * Retrieve the operand that has been submitted by the user to be included in
     * the arithmetic calculation.
     *
     * @return the saved operand to the calling method
     */
    public Number getOperand() {
        return operand;
    }


    /**
     * Append the text passed as an argument to the display text. This method
     * overloads appendToDisplay(String text, boolean replaceText).
     *
     * @param text is the text to be added to the display
     */
    public void appendToDisplay(String text) {
        appendToDisplay(text, false);
    }


    /**
     * Append the text passed as an argument to the display text. If it is possible
     * to replace the text in the display completely by passing a boolean value of true in
     * replaceText parameter. Once completed any observers of this class are notified that
     * the state of the object was changed.
     *
     * @param text is the text to be appended to the display or used to replace the display text
     * @param replaceText when true the text in the display will be replaced, otherwise the text
     *                    that is passed in the text parameter will be appended to the display
     *                    text
     */
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


    /**
     * This method overloads the appendToDisplay(String text, boolean replace) method and
     * adds some decorated logic to check if the number passed in the number argument is
     * larger than the number allowed on the display and if so it calls a formatNumber method
     * to put the number in scientific notation before appending it to the display.
     *
     * @param number is the number to be formatted and appended to the display
     * @param replaceNumber when true the number of the display will be replaced
     */
    public void appendToDisplay(Number number, boolean replaceNumber) {
        String text;

        if (number.doubleValue() > 999999999) {
            text = formatNumber(number);
        } else {
            text = number.toString();
        }

        appendToDisplay(text, replaceNumber);
    }


    /**
     * Format the number passed as an argument into scientific notication
     *
     * @param number is the number to be formatted
     * @return a String representation of the number in scientific notation
     */
    private String formatNumber(Number number) {
        NumberFormat formatter = new DecimalFormat("0.####E0");
        return formatter.format(number.doubleValue());
    }


    /**
     * Retrieves the text of the display member.
     *
     * @return a String that is the text value stored in the display member
     */
    public String getDisplay() {
        return display.getText();
    }


    /**
     * Resets the operand, operation and display to their defaults. This method is called
     * when the user taps or clicks on the "clear" button of the user interface.
     */
    public void clear() {
        setOperand(null);
        setOperation(null);
        appendToDisplay("0", true);
    }


    /**
     * Assigns an addition operation to the operation member. This method is called when
     * the user clicks the "+" button of the user interface.
     */
    public void addition() {
        setOperation(new Addition());
    }


    /**
     * Assigns a subtraction operation to the operation member. This method is called when
     * the user clicks the "-" button of the user interface.
     */
    public void subtraction() {
        setOperation(new Subtraction());
    }

    /**
     * Assigns a multiplication operation to the operation member. This method is called when
     * the user clicks the "*" button of the user interface.
     */
    public void multiplication() {
        setOperation(new Multiplication());
    }

    /**
     * Assigns a division operation to the operation member. This method is called when
     * the user clicks the "/" button of the user interface.
     */
    public void division() {
        setOperation(new Division());
    }

    /**
     * Assigns an operation to the operation member but will first try to calculate a previously
     * entered operation if when is stored in memory.
     */
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


    /**
     * Retrieves a reference to the operation member.
     * @return a reference to the operation member
     */
    private Operation getOperation() {
        return operation;
    }


    /**
     * Perform an arithmetic calculation using the operand and operation stored in memory
     * along with the most recent value from the display and then replace the value on the
     * display with the result.
     */
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


    /**
     * Retrieve the toastMessage member value.
     * @return a String that is the toastMessage value
     */
    public String getMessage() {
        return toastMessage;
    }


    /**
     * Assign the value of the toastMessage member using the value passed in the message
     * parameter.
     * @param message is a string value that is to be saved in the toastMessage member
     */
    public void setMessage(String message) {
        if(message == null) {
            toastMessage = null;
        } else {
            toastMessage = message;
        }
    }


    /**
     * Called when the observed object fires its notifyObservers method. This class
     * is observing the Display class and records when the display has been changed by the user.
     * @param observable is a reference to the display class that is being observed
     * @param data is an optional set of data that the observed object may pass to the observer
     */
    @Override
    public void update(Observable observable, Object data) {
        displayHasChanged = true;
    }
}