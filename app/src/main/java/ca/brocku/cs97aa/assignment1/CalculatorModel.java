package ca.brocku.cs97aa.assignment1;

import java.util.Observable;


public class CalculatorModel extends Observable {

    private String _display = "0";
    private boolean _appendMode = false;
    private Number _operand = null;
    private Operation _operation = null;

    public CalculatorModel() { }


    private void setOperand(String display) {
        Double number = Double.valueOf(display);

        if (number % 1 == 0) {
            _operand = number.intValue();
        } else {
            _operand = number;
        }
    }


    public Number getOperand() {
        return _operand;
    }


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


    public void subtraction() { setOperation(new Subtraction()); }


    public void multiplication() { setOperation(new Multiplication()); }


    public void division() { setOperation(new Division()); }


    private void setOperation(Operation operation) {
        calculate();
        setOperand(getDisplay());
        _operation = operation;
        _appendMode = false;
    }


    public void calculate() {
        Number result;

        if(_operation == null)
            return;

        if (_operand == null) {
            setOperand(getDisplay());
            result = getOperand();
        } else {
            Number savedOperand = getOperand();
            setOperand(getDisplay());

            result = _operation.run(savedOperand, getOperand());
        }

        _appendMode = false;
        setOperand(result.toString());
        setDisplay(result.toString());
    }
}
