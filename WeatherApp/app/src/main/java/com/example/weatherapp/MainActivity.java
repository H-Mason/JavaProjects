package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTheTemp(View view) {
        EditText editText = (EditText) findViewById(R.id.editText4);
        String city = editText.getText().toString();
        getTemp temp = new getTemp(city, this);
        Thread thread = new Thread(temp);
        thread.start();
    }
    public void getTheForecast(View view) {
        EditText editText = (EditText) findViewById(R.id.editText4);
        String city = editText.getText().toString();
        getForecast forecast = new getForecast(city, this);
        Thread thread = new Thread(forecast);
        thread.start();

    }
}
