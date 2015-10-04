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
        int result = (Integer) division.run(12,4);
        assertEquals("12 divided by 4 should equal 3", 3, result);
    }


    public void testRunWithResultAsDecimal() {
        double result = (Double) division.run(11, 4);
        assertEquals("11 divided by 4 should equal 2.75", 2.75, result);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
