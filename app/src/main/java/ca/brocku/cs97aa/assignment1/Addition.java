package ca.brocku.cs97aa.assignment1;

/**
 * Created by Curtis on 2015-09-26.
 */
public class Addition extends Operation {
    public Addition() {}


    @Override
    public Number calculate(Number operator1, Number operator2) {
        return operator1.intValue() + operator2.intValue();
    }
}
