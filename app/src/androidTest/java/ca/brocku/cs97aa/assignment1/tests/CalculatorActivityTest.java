package ca.brocku.cs97aa.assignment1.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import ca.brocku.cs97aa.assignment1.CalculatorActivity;
import ca.brocku.cs97aa.assignment1.R;


public class CalculatorActivityTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {
    CalculatorActivity activity;
    ActivityHelper helper;

    public CalculatorActivityTest() {
        super(CalculatorActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        helper = new ActivityHelper(activity, this);
    }


    public void testDisplayIsThere() {
        TextView textView = (TextView) activity.findViewById(R.id.display);
        assertNotNull("there is no display for some reason", textView);
    }


    public void testClickButton1ShouldAppendToDisplay() {
        assertEquals("it did not equal 1", "1", clickButtonAndReadDisplay(R.id.button1));
    }


    public void testClickButton2ShouldAppendToDisplay() {
        assertEquals("it did not equal 2", "2", clickButtonAndReadDisplay(R.id.button2));
    }


    public void testClickButton3ShouldAppendToDisplay() {
        assertEquals("it did not equal 3", "3", clickButtonAndReadDisplay(R.id.button3));
    }


    public void testClickButton4ShouldAppendToDisplay() {
        assertEquals("it did not equal 4", "4", clickButtonAndReadDisplay(R.id.button4));
    }


    public void testClickButton5ShouldAppendToDisplay() {
        assertEquals("it did not equal 5", "5", clickButtonAndReadDisplay(R.id.button5));
    }


    public void testClickButton6ShouldAppendToDisplay() {
        assertEquals("it did not equal 6", "6", clickButtonAndReadDisplay(R.id.button6));
    }


    public void testClickButton7ShouldAppendToDisplay() {
        assertEquals("it did not equal 7", "7", clickButtonAndReadDisplay(R.id.button7));
    }



    public void testClickButton8ShouldAppendToDisplay() {
        assertEquals("it did not equal 8", "8", clickButtonAndReadDisplay(R.id.button8));
    }


    public void testClickButton9ShouldAppendToDisplay() {
        assertEquals("it did not equal 9", "9", clickButtonAndReadDisplay(R.id.button9));
    }


    public void testClickButton0ShouldAppendToDisplay() {
        String display = clickButtonAndReadDisplay(R.id.button1);
        assertEquals("it did not equal 10", "10", clickButtonAndReadDisplay(R.id.button0));
    }


    public void testClickButtonDecimalShouldAppendToDisplay() {
        assertEquals("it did not equal .", ".", clickButtonAndReadDisplay(R.id.buttonDecimal));
    }


    private String clickButtonAndReadDisplay(int id) {
        helper.clickButton(id);
        return helper.readText(R.id.display);
    }

    public void testClickClearButtonShouldClearTheDisplay() {
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.clear_button);
        assertEquals("the clear button should reset the display to zero", "0", helper.readText(R.id.display));
    }

    public void testClickAdditionButton() {
        addElevenPlusOne();
        assertEquals("clicking a number after the addition button should display the number", "1", helper.readText(R.id.display));
    }


    public void testClickEqualsButton() {
        addElevenPlusOne();
        helper.clickButton(R.id.equals_button);
        assertEquals("eleven plus 1 should equal 12", "12", helper.readText(R.id.display));
    }


    private void addElevenPlusOne() {
        helper.clickButton(R.id.button1, 2);
        helper.clickButton(R.id.addition_button);
        helper.clickButton(R.id.button1);
    }


    public void testClickSubtractionButton() {
        helper.clickButton(R.id.button9);
        helper.clickButton(R.id.subtraction_button);
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.equals_button);
        assertEquals("9 minus 1 should display 8", "8", helper.readText(R.id.display));
    }


    public void testClickSubtractButtonWithNegativeResult() {
        helper.clickButton(R.id.button1);
        helper.clickButton(R.id.subtraction_button);
        helper.clickButton(R.id.button9);
        helper.clickButton(R.id.equals_button);
        assertEquals("1 minus 9 should display -8", "-8", helper.readText(R.id.display));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
