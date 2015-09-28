package ca.brocku.cs97aa.assignment1.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import ca.brocku.cs97aa.assignment1.CalculatorActivity;
import ca.brocku.cs97aa.assignment1.R;

/**
 * Created by Curtis on 2015-09-26.
 */
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

        Button one = (Button) activity.findViewById(R.id.button1);
        TouchUtils.clickView(this, one);

        TextView display = (TextView) activity.findViewById(R.id.display);
        String actualText = display.getText().toString();
        assertEquals("1", actualText);
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
        TouchUtils.clickView(this, (Button) activity.findViewById(R.id.equals_button));
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
