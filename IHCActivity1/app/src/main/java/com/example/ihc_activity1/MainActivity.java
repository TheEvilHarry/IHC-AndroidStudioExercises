package com.example.ihc_activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText op1;
    private EditText op2;
    private Button sumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.resultTextView);
        op1 = (EditText) findViewById(R.id.op1);
        op2 = (EditText) findViewById(R.id.op2);
        sumButton = (Button) findViewById(R.id.sumButton);
    }

    public void sumValues(View v){
        int firstValue = Integer.parseInt(op1.getText().toString());
        int secondValue = Integer.parseInt(op2.getText().toString());

        int sum = firstValue + secondValue;
        result.setText(Integer.toString(sum));
    }
}
