package ca.brocku.cs97aa.assignment1;


public class Addition extends Operation {
    public Addition() {}


    @Override
    public Number run(Number operator1, Number operator2) {
        Double result = operator1.doubleValue() + operator2.doubleValue();
        return format(result);
    }
}
