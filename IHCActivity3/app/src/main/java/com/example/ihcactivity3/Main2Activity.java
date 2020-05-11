package com.example.ihcactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView fastDirection;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backButton = (Button) findViewById(R.id.backButton);
    }

    public void goBack(View v){
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }
}
