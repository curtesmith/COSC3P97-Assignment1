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

        Button button = (Button) this.findViewById(R.id.button1);
        button.setOnClickListener(this);
        Button clear = (Button) this.findViewById(R.id.clear_button);
        clear.setOnClickListener(this);
        Button plus = (Button) this.findViewById(R.id.addition_button);
        plus.setOnClickListener(this);
        Button equals = (Button) this.findViewById(R.id.equals_button);
        equals.setOnClickListener(this);
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
