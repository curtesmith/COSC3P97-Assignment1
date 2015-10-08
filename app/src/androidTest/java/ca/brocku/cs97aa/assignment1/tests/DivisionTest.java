package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Division;


public class DivisionTest extends TestCase {
    private Division division;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        division = new Division();
    }


    public void testRun() {
        try {
            int result = (Integer) division.run(12, 4);
            assertEquals("12 divided by 4 should equal 3", 3, result);
        } catch (Exception ex) {
            fail("an unexpected exception was thrown, message=[" + ex.getMessage() + "]");
        }
    }


    public void testRunWithResultAsDecimal() {
        try {
            double result = (Double) division.run(11, 4);
            assertEquals("11 divided by 4 should equal 2.75", 2.75, result);
        } catch (Exception ex) {

            fail("an unexpected exception was thrown, message=[" + ex.getMessage() + "]");
        }
    }


    public void testRunWithDivisionByZero() {
        String message = "";
        try {
            double result = (Double) division.run(11, 0);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals("no exception was thrown", "Cannot divide by zero", message);
    }



    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
