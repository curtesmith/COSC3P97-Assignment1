package ca.brocku.cs97aa.assignment1;

import java.util.Observable;

/**
 * Created by Curtis on 2015-09-26.
 */
public class CalculatorModel extends Observable {

    private String _display = "0";
    private boolean _appendMode = false;
    private Number _operand = null;
    private Operation _operation = null;

    public CalculatorModel() { }

    public void setDisplay(String text) {
        _display = text;
        setChanged();
        notifyObservers();
    }

    public void appendToDisplay(String text) {
        if (_appendMode) {
            setDisplay(getDisplay() + text);
        } else {
            _appendMode = true;
            setDisplay(text);
        }
    }

    public String getDisplay() {
        return _display;
    }

    public void clearDisplay() {
        _appendMode = false;
        _operand = null;
        _operation = null;
        setDisplay("0");
    }

    public void addition() {
        setOperation(new Addition());
    }


    private void setOperation(Operation operation) {
        calculate();
        _operand = Integer.valueOf(getDisplay());
        _operation = operation;
        _appendMode = false;
    }

    public void calculate() {
        Number result;

        if (_operand == null) {
            result = Integer.valueOf(getDisplay());
        } else {
            result = _operation.calculate(_operand, Integer.valueOf(getDisplay()));
        }

        _appendMode = false;
        _operand = result;
        setDisplay(result.toString());
    }
}
