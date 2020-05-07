package com.example.ihcactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String text;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
    }

    public void buttonClicked(View v){
        text = input.getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("MESSAGE",text);
        finish();
        startActivity(intent);
    }
}
