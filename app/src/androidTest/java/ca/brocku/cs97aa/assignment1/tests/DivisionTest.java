package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Division;


/**
 * Test class to test the run method of the Division class
 */
public class DivisionTest extends TestCase {
    private Division division;


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        division = new Division();
    }


    /**
     * Test division of operands 12 and 4 which should equal 3.
     */
    public void testRun() {
        try {
            long result = (Long) division.run(12, 4);
            assertEquals("12 divided by 4 should equal 3", 3, result);
        } catch (Exception ex) {
            fail("an unexpected exception was thrown, message=[" + ex.getMessage() + "]");
        }
    }


    /**
     * Test division with operands 11 and 4 which should equal 2.75.
     */
    public void testRunWithResultAsDecimal() {
        try {
            double result = (Double) division.run(11, 4);
            assertEquals("11 divided by 4 should equal 2.75", 2.75, result);
        } catch (Exception ex) {

            fail("an unexpected exception was thrown, message=[" + ex.getMessage() + "]");
        }
    }


    /**
     * Test division by zero which should throw and exception.
     */
    public void testRunWithDivisionByZero() {
        String message = "";
        try {
            double result = (Double) division.run(11, 0);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals("no exception was thrown", "Cannot divide by zero", message);
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
