package ca.brocku.cs97aa.assignment1;

/**
 * Extends the Operation class to implement the run() method following a command
 * pattern.
 */
public class Division extends Operation{


    /**
     * Empty default constructor
     */
    public Division() {}


    /**
     * Performs division of two operators passed as parameters and returns the result.
     * Checks for division by zero and throws an exception when appropriate.
     *
     * @param operator1 is the first operator
     * @param operator2 is the second operator
     * @return the result as a subclass of the abstract class Number
     */
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
