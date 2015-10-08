package ca.brocku.cs97aa.assignment1.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import ca.brocku.cs97aa.assignment1.CalculatorActivity;
import ca.brocku.cs97aa.assignment1.R;


/**
 * Test class to test the Calculator user interface
 */
public class CalculatorActivityTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {
    CalculatorActivity activity;
    ActivityHelper helper;


    /**
     * Default empty constructor
     */
    public CalculatorActivityTest() {
        super(CalculatorActivity.class);
    }


    /**
     * Used to perform any activities that need to be done prior to each test.
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        helper = new ActivityHelper(activity, this);
    }


    /**
     * Test to confirm that the TextView for the display is in the user interface.
     */
    public void testDisplayIsThere() {
        TextView textView = (TextView) activity.findViewById(R.id.display);
        assertNotNull("there is no display for some reason", textView);
    }


    /**
     * Test that when the user clicks on the "1" button that the number 1 is added to the
     * display TextView.
     */
    public void testClickButton1ShouldAppendToDisplay() {
        assertEquals("it did not equal 1", "1", clickButtonAndReadDisplay(R.id.button1));
    }


    /**
     * Test that when the user clicks on the "2" button that the number 2 is added to the
     * display TextView.
     */
    public void testClickButton2ShouldAppendToDisplay() {
        assertEquals("it did not equal 2", "2", clickButtonAndReadDisplay(R.id.button2));
    }


    /**
     * Test that when the user clicks on the "3" button that the number 3 is added to the
     * display TextView.
     */
    public void testClickButton3ShouldAppendToDisplay() {
        assertEquals("it did not equal 3", "3", clickButtonAndReadDisplay(R.id.button3));
    }


    /**
     * Test that when the user clicks on the "4" button that the number 4 is added to the
     * display TextView.
     */
    public void testClickButton4ShouldAppendToDisplay() {
        assertEquals("it did not equal 4", "4", clickButtonAndReadDisplay(R.id.button4));
    }


    /**
     * Test that when the user clicks on the "5" button that the number 5 is added to the
     * display TextView.
     */
    public void testClickButton5ShouldAppendToDisplay() {
        assertEquals("it did not equal 5", "5", clickButtonAndReadDisplay(R.id.button5));
    }


    /**
     * Test that when the user clicks on the "6" button that the number 6 is added to the
     * display TextView.
     */
    public void testClickButton6ShouldAppendToDisplay() {
        assertEquals("it did not equal 6", "6", clickButtonAndReadDisplay(R.id.button6));
    }


    /**
     * Test that when the user clicks on the "7" button that the number 7 is added to the
     * display TextView.
     */
    public void testClickButton7ShouldAppendToDisplay() {
        assertEquals("it did not equal 7", "7", clickButtonAndReadDisplay(R.id.button7));
    }


    /**
     * Test that when the user clicks on the "8" button that the number 8 is added to the
     * display TextView.
     */
    public void testClickButton8ShouldAppendToDisplay() {
        assertEquals("it did not equal 8", "8", clickButtonAndReadDisplay(R.id.button8));
    }


    /**
     * Test that when the user clicks on the "9" button that the number 9 is added to the
     * display TextView.
     */
    public void testClickButton9ShouldAppendToDisplay() {
        assertEquals("it did not equal 9", "9", clickButtonAndReadDisplay(R.id.button9));
    }


    /**
     * Test that when the user clicks on the "0" button that the number 0 is added to the
     * display TextView.
     */
    public void testClickButton0ShouldAppendToDisplay() {
        String display = clickButtonAndReadDisplay(R.id.button1);
        assertEquals("it did not equal 10", "10", clickButtonAndReadDisplay(R.id.button0));
    }


    /**
     * Test that when the user clicks on the "." button that the decimal point is added to the
     * display TextView.
     */
    public void testClickButtonDecimalShouldAppendToDisplay() {
        assertEquals("it did not equal .", ".", clickButtonAndReadDisplay(R.id.decimal_button));
    }


    /**
     * A helper method to click a button of the user interface and read the display TextView
     * @param id is the id of the button to be clicked
     * @return a String value in the display TextView
     */
    private String clickButtonAndReadDisplay(int id) {
        helper.clickButton(id);
        return helper.readText(R.id.display);
    }


    /**
     * Test that when the user clicks on the "clear" button that the the value in the display
     * TextView is replaced with a value of 0.
     */
    public void testClickClearButtonShouldClearTheDisplay() {
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.clear_button);
        assertEquals("the clear button should reset the display to zero", "0", helper.readText(R.id.display));
    }


    /**
     * Test that clicking the "+" button should allow the entry of a new operand
     */
    public void testClickAdditionButton() {
        addElevenPlusOne();
        assertEquals("clicking a number after the addition button should display the number", "1", helper.readText(R.id.display));
    }


    /**
     * Test that clicking the "=" button should update the display with the result of the calculation
     */
    public void testClickEqualsButton() {
        addElevenPlusOne();
        helper.clickButton(R.id.equals_button);
        assertEquals("eleven plus 1 should equal 12", "12", helper.readText(R.id.display));
    }


    /**
     * Perform the actions of typing in "11", "+" and "1".
     */
    private void addElevenPlusOne() {
        helper.clickButton(R.id.button1, 2);
        helper.clickButton(R.id.addition_button);
        helper.clickButton(R.id.button1);
    }


    /**
     * Test that clicking the "9", "-", "1" and "=" should display "8".
     */
    public void testClickSubtractionButton() {
        helper.clickButton(R.id.button9);
        helper.clickButton(R.id.subtraction_button);
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.equals_button);
        assertEquals("9 minus 1 should display 8", "8", helper.readText(R.id.display));
    }


    /**
     * Test that clicking the "1", "-", "9" and "=" should display "-8".
     */
    public void testClickSubtractButtonWithNegativeResult() {
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.subtraction_button);
        helper.clickButton(R.id.button9);
        helper.clickButton(R.id.equals_button);
        assertEquals("1 minus 9 should display -8", "-8", helper.readText(R.id.display));
    }


    /**
     * Test that clicking the "3", "*", "4" and "=" should display "12".
     */
    public void testClickMultiplicationButton() {
        helper.clickButton(R.id.button3);
        helper.clickButton(R.id.multiplication_button);
        helper.clickButton(R.id.button4);
        helper.clickButton(R.id.equals_button);
        assertEquals("3 times 4 should display 12", "12", helper.readText(R.id.display));
    }


    /**
     * Test that clicking the "11", "/", "4" and "=" should display "2.75".
     */
    public void testClickDivisionButton() {
        helper.clickButton(R.id.button1, 2);
        helper.clickButton(R.id.division_button);
        helper.clickButton(R.id.button4);
        helper.clickButton(R.id.equals_button);
        assertEquals("11 divided by 4 should display 2.75", "2.75", helper.readText(R.id.display));
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
