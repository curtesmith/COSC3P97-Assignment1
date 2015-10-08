package ca.brocku.cs97aa.assignment1.tests;


import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Subtraction;


/**
 * Test class to test the run method of the Subtraction class
 */
public class SubrtactionTest extends TestCase{
    private Subtraction subtraction;


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        subtraction = new Subtraction();
    }


    /**
     * Test subtraction of the operands 3 and 1 which should equal 2.
     */
    public void testRun() {
        long result = (Long) subtraction.run(3,1);
        assertEquals("3 minus 1 did not equal 2", 2, result);
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
