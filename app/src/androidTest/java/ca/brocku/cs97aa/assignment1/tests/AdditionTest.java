package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.Addition;


public class AdditionTest extends TestCase {
    private Addition operation;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testRun() {
        assertEquals("the result was not 3", 3, (new Addition().run(1, 2)).intValue());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
