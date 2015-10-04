package ca.brocku.cs97aa.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class CalculatorActivity extends Activity implements Observer, View.OnClickListener {

    private CalculatorModel calculatorModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calculatorModel = new CalculatorModel();
        calculatorModel.addObserver(this);

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
        setOnClickButtonListener(R.id.buttonDecimal);
        setOnClickButtonListener(R.id.clear_button);
        setOnClickButtonListener(R.id.addition_button);
        setOnClickButtonListener(R.id.equals_button);
    }


    private void setOnClickButtonListener(int buttonId) {
        Button button = (Button) this.findViewById(buttonId);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void update(Observable observable, Object data) {
        TextView display = (TextView) this.findViewById(R.id.display);
        display.setText(calculatorModel.getDisplay());
    }


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
            case R.id.equals_button:
                calculatorModel.calculate();
                break;
            default:
                calculatorModel.appendToDisplay(button.getText().toString());
                break;
        }
    }

}
