package com.example.ihcactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    String text;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        output = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        text = intent.getStringExtra("MESSAGE");
        output.setText(text);
    }

    public void goBack(View v){
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }
}
