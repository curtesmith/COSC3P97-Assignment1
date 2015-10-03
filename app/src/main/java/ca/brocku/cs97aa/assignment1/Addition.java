package ca.brocku.cs97aa.assignment1;


public class Addition extends Operation {
    public Addition() {}


    @Override
    public Number calculate(Number operator1, Number operator2) {
        Double result = operator1.doubleValue() + operator2.doubleValue();
        if (result % 1 == 0) {
            return result.intValue();
        } else {
            return result;
        }
    }
}
