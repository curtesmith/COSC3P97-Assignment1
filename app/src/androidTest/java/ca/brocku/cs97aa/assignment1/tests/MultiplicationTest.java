package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Multiplication;


public class MultiplicationTest extends TestCase {

    private Multiplication multiplication;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        multiplication = new Multiplication();
    }


    public void testRun() {
        long result = (Long) multiplication.run(3,4);
        assertEquals("3 times 4 should equal 12", 12, result);
    }

    public void testRunWithOneNegativeOperand() {
        long result = (Long) multiplication.run(3,-4);
        assertEquals("3 times -4 should equal -12", -12, result);
    }

    public void testRunWithOneNegativeDecimalOperand() {
        double result = (Double) multiplication.run(3,-4.5);
        assertEquals("3 times -4 should equal -13.5", -13.5, result);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
