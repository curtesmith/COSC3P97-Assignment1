package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Multiplication;


/**
 * Test class to test the run method of the Multiplication class
 */
public class MultiplicationTest extends TestCase {

    private Multiplication multiplication;


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        multiplication = new Multiplication();
    }


    /**
     * Test multiplication of the operands 3 and 4 which should equal 12.
     */
    public void testRun() {
        long result = (Long) multiplication.run(3,4);
        assertEquals("3 times 4 should equal 12", 12, result);
    }


    /**
     * Test multiplication of the operands 3 and -4 which should equal -12.
     */
    public void testRunWithOneNegativeOperand() {
        long result = (Long) multiplication.run(3,-4);
        assertEquals("3 times -4 should equal -12", -12, result);
    }


    /**
     * Test multiplication of the operands 3 and -4 which should equal -13.5.
     */
    public void testRunWithOneNegativeDecimalOperand() {
        double result = (Double) multiplication.run(3,-4.5);
        assertEquals("3 times -4.5 should equal -13.5", -13.5, result);
    }


    /**
     * Used to perform any activities that need to be done after each test.
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
