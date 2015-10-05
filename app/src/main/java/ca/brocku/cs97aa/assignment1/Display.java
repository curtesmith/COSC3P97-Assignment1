package ca.brocku.cs97aa.assignment1;


public class Display {
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
