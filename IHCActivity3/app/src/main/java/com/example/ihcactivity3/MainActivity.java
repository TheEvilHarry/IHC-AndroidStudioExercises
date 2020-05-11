package com.example.ihcactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private float accel1;
    private float accel2;
    private float accel3;
    private boolean changed=false;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private long lastUpdate=0;
    private float disturbance = 5;
    private float gravity[] = {0,0,0};
    private float alpha = (float) 0.8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        editText1 = (EditText) findViewById(R.id.acceler1);
        editText2 = (EditText) findViewById(R.id.acceler2);
        editText3 = (EditText) findViewById(R.id.acceler3);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor sensor = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER) {




            // Isolate the force of gravity with the low-pass filter.
            gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];

            float curr_accel1 = sensorEvent.values[0] - gravity[0];
            float curr_accel2 = sensorEvent.values[1] - gravity[1];
            float curr_accel3 = sensorEvent.values[2] - gravity[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 300) {


                editText1.setText("X:" + Float.toString(curr_accel1));
                editText2.setText("Y:" + Float.toString(curr_accel2));
                editText3.setText("Z:" + Float.toString(curr_accel3));

                if(!changed){
                    accel1 = curr_accel1;
                    accel2 = curr_accel2;
                    accel3 = curr_accel3;
                    changed=true;
                }
                else{
                    if(curr_accel1 - accel1 >= disturbance ){
                        tooFast("X");
                    }
                    else if(curr_accel2 - accel2 >= disturbance){
                        tooFast("Y");
                    }
                    else if( curr_accel3 - accel3 >= disturbance){
                        tooFast("Z");
                    }
                    else{
                        accel1 = curr_accel1;
                        accel2 = curr_accel2;
                        accel3 = curr_accel3;
                    }
                }
            }

        }

    }

    private void tooFast(String eixo){
        Intent intent = new Intent(this,Main2Activity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
