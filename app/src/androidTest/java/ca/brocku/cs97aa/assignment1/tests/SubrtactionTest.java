package ca.brocku.cs97aa.assignment1.tests;


import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Subtraction;

public class SubrtactionTest extends TestCase{
    private Subtraction subtraction;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        subtraction = new Subtraction();
    }


    public void testRun() {
        int result = (Integer) subtraction.run(3,1);
        assertEquals("3 minus 1 did not equal 2", 2, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
