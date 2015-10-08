package ca.brocku.cs97aa.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 * The main Android activity responsible for displaying the UI and handling the
 * user interactions
 */
public class CalculatorActivity extends Activity implements Observer, OnClickListener {

    private CalculatorModel calculatorModel;

    /**
     * Called when the activity is starting and handles most of the setup instructions.
     * This class implements uses an observer pattern to respond to changes when notified
     * by the calculatorModel member. It also implements OnClickListener so that it can
     * handle and respond to user events triggered by the user interface.
     *
     * @param savedInstanceState contains data that can be retrieved if the activity is
     *                           being reintialized
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calculatorModel = new CalculatorModel();
        calculatorModel.addObserver(this);
        setupOnClickListeners();
    }


    /**
     * Attach a listener to all button click events from the user interface
     */
    private void setupOnClickListeners() {
        setOnClickButtonListener(R.id.button0);
        setOnClickButtonListener(R.id.button1);
        setOnClickButtonListener(R.id.button2);
        setOnClickButtonListener(R.id.button3);
        setOnClickButtonListener(R.id.button4);
        setOnClickButtonListener(R.id.button5);
        setOnClickButtonListener(R.id.button6);
        setOnClickButtonListener(R.id.button7);
        setOnClickButtonListener(R.id.button8);
        setOnClickButtonListener(R.id.button9);
        setOnClickButtonListener(R.id.decimal_button);
        setOnClickButtonListener(R.id.clear_button);
        setOnClickButtonListener(R.id.addition_button);
        setOnClickButtonListener(R.id.subtraction_button);
        setOnClickButtonListener(R.id.multiplication_button);
        setOnClickButtonListener(R.id.division_button);
        setOnClickButtonListener(R.id.equals_button);
    }


    /**
     * Attach a listener to the button identified by the buttonId parameter
     *
     * @param buttonId the id of the button that requires an onclick listener
     */
    private void setOnClickButtonListener(int buttonId) {
        Button button = (Button) this.findViewById(buttonId);
        button.setOnClickListener(this);
    }


    /**
     * Called when the calculatorModel notifies the activity/observer that its state has
     * changed. When invoked the activity updates the display (TextView) with the display
     * value stored in the model. It also checks if the model has any messages that
     * should be displayed as a toast to the user.
     *
     * @param observable is the model being observed by the activity
     * @param data is any data passed by the model being observed
     */
    @Override
    public void update(Observable observable, Object data) {
        TextView display = (TextView) this.findViewById(R.id.display);
        CalculatorModel model = (CalculatorModel) observable;
        display.setText(model.getDisplay());
        if(model.getMessage() != null) {
            Toast toast = Toast.makeText(getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
            model.setMessage(null);
        }
    }


    /**
     * onClick event handler that is set to be called when any of the buttons in the user
     * interface are clicked. This method checks the source of the event by comparing the id
     * of the button and then transferring control to the appropriate method of the
     * calculatorModel member.
     *
     * @param v is the widget that was clicked
     */
    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        switch (button.getId()) {
            case R.id.clear_button:
                calculatorModel.clear();
                break;
            case R.id.addition_button:
                calculatorModel.addition();
                break;
            case R.id.subtraction_button:
                calculatorModel.subtraction();
                break;
            case R.id.multiplication_button:
                calculatorModel.multiplication();
                break;
            case R.id.division_button:
                calculatorModel.division();
                break;
            case R.id.equals_button:
                calculatorModel.calculate();
                break;
            case R.id.decimal_button:
                calculatorModel.appendDecimal();
                break;
            default:
                calculatorModel.appendToDisplay(button.getText().toString());
                break;
        }
    }

}
