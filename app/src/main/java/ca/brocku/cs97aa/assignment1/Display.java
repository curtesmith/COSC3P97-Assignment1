package ca.brocku.cs97aa.assignment1;


import java.util.Observable;

public class Display extends Observable {
    private String text;
    private boolean appendModeOff;


    public Display() {
        setAppendModeOff();
        setText("0");
    }


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


    public void setText(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }


    public void setAppendModeOn() {
        appendModeOff = false;
    }


    public void setAppendModeOff() {
        appendModeOff = true;
    }


    public boolean isAppendModeOff() {
        return appendModeOff;
    }
}
