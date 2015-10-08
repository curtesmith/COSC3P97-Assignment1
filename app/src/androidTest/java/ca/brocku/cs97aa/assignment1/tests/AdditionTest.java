package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Addition;

/**
 * Test class to test the run method of the Addition class
 */
public class AdditionTest extends TestCase {
    private Addition operation;


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    /**
     * Test addition of the operands 1 and 2 which should equal 3.     *
     */
    public void testRunWithOperands1and2WhichShouldEqual3() {
        assertEquals("The result was not 3", 3, (new Addition().run(1, 2)).intValue());
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
