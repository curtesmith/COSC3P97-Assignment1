package ca.brocku.cs97aa.assignment1;


/**
 * An abstract class used as a base class for the other operations following
 * the command pattern.
 */
public abstract class Operation {

    /**
     * The main method in the command pattern that will be responsible for executing
     * the command that the operation represents.
     *
     * @param operator1 is the first operator
     * @param operator2 is the second operator
     * @return the result as a subclass of the abstract class Number
     * @throws Exception when appropriate such as when there is a division by zero
     */
    public abstract Number run(Number operator1, Number operator2) throws Exception;


    /**
     * Will format the number as an long value when the number is evenly divisible by
     * a value of 1 otherwise the number is formatted as a double.
     *
     * @param number is the number to be formatted
     * @return the formatted number
     */
    protected static Number format(Double number) {
        if (number % 1 == 0) {
            return number.longValue();
        } else {
            return number;
        }
    }
}
