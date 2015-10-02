package ca.brocku.cs97aa.assignment1.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import ca.brocku.cs97aa.assignment1.CalculatorActivity;
import ca.brocku.cs97aa.assignment1.R;


public class CalculatorActivityTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {
    CalculatorActivity activity;

    public CalculatorActivityTest() {
        super(CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testDisplayIsThere() {
        TextView textView = (TextView) activity.findViewById(R.id.display);
        assertNotNull("there is no display for some reason", textView);
    }


    public void testButtonIsThere() {
        Button button = (Button) activity.findViewById(R.id.button1);
        assertNotNull("there is no button for some reason", button);
    }


    public void testClickButton1ShouldAppendToDisplay() {
        assertEquals("it did not equal 1", "1", clickNumberButtonHelper(R.id.button1));
    }


    public void testClickButton2ShouldAppendToDisplay() {
        assertEquals("it did not equal 2", "2", clickNumberButtonHelper(R.id.button2));
    }


    public void testClickButton3ShouldAppendToDisplay() {
        assertEquals("it did not equal 3", "3", clickNumberButtonHelper(R.id.button3));
    }


    public void testClickButton4ShouldAppendToDisplay() {
        assertEquals("it did not equal 4", "4", clickNumberButtonHelper(R.id.button4));
    }


    public void testClickButton5ShouldAppendToDisplay() {
        assertEquals("it did not equal 5", "5", clickNumberButtonHelper(R.id.button5));
    }


    public void testClickButton6ShouldAppendToDisplay() {
        assertEquals("it did not equal 6", "6", clickNumberButtonHelper(R.id.button6));
    }


    public void testClickButton7ShouldAppendToDisplay() {
        assertEquals("it did not equal 7", "7", clickNumberButtonHelper(R.id.button7));
    }


    public void testClickButton8ShouldAppendToDisplay() {
        assertEquals("it did not equal 8", "8", clickNumberButtonHelper(R.id.button8));
    }


    public void testClickButton9ShouldAppendToDisplay() {
        assertEquals("it did not equal 9", "9", clickNumberButtonHelper(R.id.button9));
    }

    public void testClickButton0ShouldAppendToDisplay() {
        String display = clickNumberButtonHelper(R.id.button1);
        assertEquals("it did not equal 10", "10", clickNumberButtonHelper(R.id.button0));
    }


    private String clickNumberButtonHelper(int id) {
        Button button = (Button) activity.findViewById(id);
        TouchUtils.clickView(this, button);
        TextView display = (TextView) activity.findViewById(R.id.display);
        return display.getText().toString();
    }

    public void testClickClearButtonShouldClearTheDisplay() {
        Button one = (Button) activity.findViewById(R.id.button1);
        Button clear = (Button) activity.findViewById(R.id.clear_button);
        TouchUtils.clickView(this, one);
        TouchUtils.clickView(this, clear);

        TextView display = (TextView) activity.findViewById(R.id.display);
        String actualText = display.getText().toString();
        assertEquals("0", actualText);
    }

    public void testClickAdditionButton() {
        clickAdditionButton();

        TextView display = (TextView) activity.findViewById(R.id.display);
        assertEquals("1", display.getText().toString());
    }

    public void testClickEqualsButton() {
        clickAdditionButton();
        TouchUtils.clickView(this, activity.findViewById(R.id.equals_button));
        assertEquals("12", ((TextView) activity.findViewById(R.id.display)).getText().toString());
    }

    private void clickAdditionButton() {
        Button one = (Button) activity.findViewById(R.id.button1);
        TouchUtils.clickView(this, one);
        TouchUtils.clickView(this, one);
        Button plus = (Button) activity.findViewById(R.id.addition_button);
        TouchUtils.clickView(this, plus);
        TouchUtils.clickView(this, one);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
