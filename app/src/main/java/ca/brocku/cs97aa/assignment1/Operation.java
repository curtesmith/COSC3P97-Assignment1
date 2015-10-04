package ca.brocku.cs97aa.assignment1;


public abstract class Operation {
    public abstract Number run(Number operator1, Number operator2);

    protected Number format(Double number) {
        if (number % 1 == 0) {
            return number.intValue();
        } else {
            return number;
        }
    }
}
