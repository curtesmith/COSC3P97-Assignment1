package ca.brocku.cs97aa.assignment1.tests;

import junit.framework.TestCase;

import ca.brocku.cs97aa.assignment1.CalculatorModel;

/**
 * Created by Curtis on 2015-09-26.
 */
public class CalculatorModelTest extends TestCase {
    private CalculatorModel calculatorModel;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        calculatorModel = new CalculatorModel();
    }

    public void testSetDisplay() {
        String expected = "some value";
        calculatorModel.setDisplay(expected);
        assertEquals("something happened with the setDisplay", expected, calculatorModel.getDisplay());
    }

    public void testAppendToDisplay() {
        calculatorModel.appendToDisplay("5");
        assertEquals("something happened with the appendToDisplay", "5", calculatorModel.getDisplay());
    }

    public void testClearDisplay() {
        calculatorModel.setDisplay("12345");
        calculatorModel.clearDisplay();
        assertEquals("it didn't clear", "0", calculatorModel.getDisplay());
    }

    public void testAddition() {

    }
}
