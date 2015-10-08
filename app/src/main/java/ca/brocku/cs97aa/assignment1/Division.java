package ca.brocku.cs97aa.assignment1;


public class Division extends Operation{

    public Division() {}


    @Override
    public Number run(Number operator1, Number operator2) throws Exception {
        if(operator2.doubleValue() == 0) {
            throw new Exception("Cannot divide by zero");
        } else {
            Double result = operator1.doubleValue() / operator2.doubleValue();
            return format(result);
        }
    }
}
