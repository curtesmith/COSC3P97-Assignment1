package ca.brocku.cs97aa.assignment1;


import java.util.Observable;


/**
 * Represents a model of the display that is visible to the user and is
 * used to manage text updates and notifications back to the calculatorModel observer.
 */
public class Display extends Observable {
    private String text;
    private boolean appendModeOff;


    /**
     * Constructor that assigns member default values
     */
    public Display() {
        setAppendModeOff();
        setText("0");
    }


    /**
     * Logic to append or replace the text that will be displayed back to the
     * user through the user interface. When the text member is updated this class will
     * notify the calculatorModel observer that it has been changed.
     *
     * @param text is the text that will be used to udpate the display
     */
    public void appendText(String text) {
        if(text == null) {
            return;
        }

        if(isAppendModeOff()) {
            setText(text);
            setAppendModeOn();
        } else {
            setText(getText() + text);
        }

        setChanged();
        notifyObservers();
    }


    /**
     * Assign a String value to the text member
     *
     * @param text is the value that will be stored in the text member
     */
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Retrieve the text value from the text member.
     *
     * @return a String value that is stored in the text member
     */
    public String getText() {
        return text;
    }


    /**
     * Assign a boolean value of false to the appendModeOff member which signals
     * that any text should be appended to the display.
     */
    public void setAppendModeOn() {
        appendModeOff = false;
    }


    /**
     * Assign a boolean value of true to the appendModeOff member which signals
     * that any text should not be appended to the display.
     */
    public void setAppendModeOff() {
        appendModeOff = true;
    }


    /**
     * Returns a boolean value of true if the appendModeOff member is true.
     * @return a boolean value of true when the appendMode is off otherwise it
     * returns a value of false
     */
    public boolean isAppendModeOff() {
        return appendModeOff;
    }
}