package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.CalculatorModel;

/**
 * Test class to test the calculator model
 */
public class CalculatorModelTest extends TestCase {
    private CalculatorModel calculatorModel;


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        calculatorModel = new CalculatorModel();
    }


    /**
     * Test that the display holds a value of "0" by default.
     */
    public void testGetDisplay() {
        assertEquals("the display should equal zero", "0", calculatorModel.getDisplay());
    }


    /**
     * Test that appendingToDisplay will update the text of the display member
     */
    public void testAppendToDisplay() {
        calculatorModel.appendToDisplay("5");
        assertEquals("something happened with the appendToDisplay", "5", calculatorModel.getDisplay());
    }


    /**
     * Test the clear method will reset the display text to "0".
     */
    public void testClear() {
        calculatorModel.appendToDisplay("12345");
        calculatorModel.clear();
        assertEquals("it didn't clear", "0", calculatorModel.getDisplay());
    }


    /**
     * Test that addition of 12 and 13 gives 25.
     */
    public void testAddition() {
        calculatorModel.appendToDisplay("12");
        calculatorModel.addition();
        calculatorModel.appendToDisplay("13");
        calculatorModel.calculate();
        assertEquals("12 + 13 should equal 25", "25", calculatorModel.getDisplay());
    }


    /**
     * Test that subtraction of 3 minus 1 gives 2.
     */
    public void testSubtraction() {
        calculatorModel.appendToDisplay("3");
        calculatorModel.subtraction();
        calculatorModel.appendToDisplay("1");
        calculatorModel.calculate();
        assertEquals("3 minus 1 should equal 2", "2", calculatorModel.getDisplay());
    }


    /**
     * Test that the calculate method will not update the display if the model only
     * has no operand and no operation saved.
     */
    public void testCalculateWithNoOperation() {
        calculatorModel.appendToDisplay("22");
        calculatorModel.calculate();
        assertEquals("the display should still be 22", "22", calculatorModel.getDisplay());
    }


    /**
     * Test that the calculate method will not update the display if the model only
     * has 1 operand stored.
     */
    public void testCalculateWithOneOperand() {
        calculatorModel.appendToDisplay("23");
        calculatorModel.addition();
        calculatorModel.calculate();
        assertEquals("the display should still be 46", "46", calculatorModel.getDisplay());
    }


    /**
     * Test that addition with decimal (ie. double) values will not be truncated.
     */
    public void testAdditionWithDouble() {
        calculatorModel.appendToDisplay("1.5");
        calculatorModel.addition();
        calculatorModel.appendToDisplay("2");
        calculatorModel.calculate();
        assertEquals("the display did not have 3.5", "3.5", calculatorModel.getDisplay());
    }


    /**
     * Test that multiplication of 3 times 4 updates the display with a value of 12.
     */
    public void testMultiplication() {
        calculatorModel.appendToDisplay("3");
        calculatorModel.multiplication();
        calculatorModel.appendToDisplay("4");
        calculatorModel.calculate();
        assertEquals("it should display 12", "12", calculatorModel.getDisplay());
    }


    /**
     * Test that division of 11 divided by 4 updates the display with a value of 2.75.
     */
    public void testDivision() {
        calculatorModel.appendToDisplay("11");
        calculatorModel.division();
        calculatorModel.appendToDisplay("4");
        calculatorModel.calculate();
        assertEquals("it should display 2.75", "2.75", calculatorModel.getDisplay());
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
