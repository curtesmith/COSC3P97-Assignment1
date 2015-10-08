package ca.brocku.cs97aa.assignment1;

/**
 * Extends the Operation class to implement the run() method following a command
 * pattern.
 */
public class Addition extends Operation {

    /**
     * Empty default constructor
     */
    public Addition() {}


    /**
     * Performs addition of two operators passed as parameters and returns the result.
     * @param operator1 is the first operator
     * @param operator2 is the second operator
     * @return the result as a subclass of the abstract class Number
     */
    @Override
    public Number run(Number operator1, Number operator2) {
        Double result = operator1.doubleValue() + operator2.doubleValue();
        return format(result);
    }
}
