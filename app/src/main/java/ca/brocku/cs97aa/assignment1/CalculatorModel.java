package ca.brocku.cs97aa.assignment1;

import java.util.Observable;


public class CalculatorModel extends Observable {

    private String _display = "0";
    private boolean _appendMode = false;
    private Number _operand = null;
    private Operation _operation = null;

    public CalculatorModel() { }


    public void appendToDisplay(String text) {
        if (_appendMode) {
            setDisplay(getDisplay() + text);
        } else {
            _appendMode = true;
            setDisplay(text);
        }
    }


    private void setDisplay(String text) {
        _display = text;
        setChanged();
        notifyObservers();
    }


    public String getDisplay() {
        return _display;
    }


    public void clear() {
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

        if(_operation == null)
            return;

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
