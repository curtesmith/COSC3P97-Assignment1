package ca.brocku.cs97aa.assignment1.tests;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;


public class ActivityHelper {
    private Activity activity;
    private ActivityInstrumentationTestCase2 testCase;


    public ActivityHelper(Activity activity, ActivityInstrumentationTestCase2 testCase) {
        this.activity = activity;
        this.testCase = testCase;
    }


    public void clickButton(int id) {
        clickButton(id, 1);
    }


    public void clickButton(int id, int times) {
        Button button = (Button) activity.findViewById(id);
        for (int i = 0; i < times; i++) {
            TouchUtils.clickView(testCase, button);
        }
    }


    public String readText(int id) {
        TextView display = (TextView) activity.findViewById(id);
        return display.getText().toString();
    }
}
