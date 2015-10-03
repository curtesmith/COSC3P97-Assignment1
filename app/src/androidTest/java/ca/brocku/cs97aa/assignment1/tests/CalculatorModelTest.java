package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.CalculatorModel;


public class CalculatorModelTest extends TestCase {
    private CalculatorModel calculatorModel;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        calculatorModel = new CalculatorModel();
    }

    public void testGetDisplay() {
        assertEquals("the display should equal zero", "0", calculatorModel.getDisplay());
    }

    public void testAppendToDisplay() {
        calculatorModel.appendToDisplay("5");
        assertEquals("something happened with the appendToDisplay", "5", calculatorModel.getDisplay());
    }

    public void testClear() {
        calculatorModel.appendToDisplay("12345");
        calculatorModel.clear();
        assertEquals("it didn't clear", "0", calculatorModel.getDisplay());
    }

    public void testAddition() {
        calculatorModel.appendToDisplay("12");
        calculatorModel.addition();
        calculatorModel.appendToDisplay("13");
        calculatorModel.calculate();
        assertEquals("12 + 13 should equal 25", "25", calculatorModel.getDisplay());
    }

    public void testCalculateWithNoOperation() {
        calculatorModel.appendToDisplay("22");
        calculatorModel.calculate();
        assertEquals("the display should still be 22", "22", calculatorModel.getDisplay());
    }

    public void testCalculateWithOneOperand() {
        calculatorModel.appendToDisplay("23");
        calculatorModel.addition();
        calculatorModel.calculate();
        assertEquals("the display should still be 46", "46", calculatorModel.getDisplay());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
