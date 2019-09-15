package com.example.weatherapp;

import android.app.Activity;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class getForecast implements Runnable {
    String city;
    String weatherData;
    String w;
    private WeakReference<Activity> activityRef;
    public getForecast(String cityName, Activity activity) {
        city = cityName;
        w = "forecast";
        this.activityRef = new WeakReference<Activity>(activity);
    }
    @Override
    public void run() {
        Gson gson = new Gson();
        DataLoader weatherJSON = null;
        try {
            weatherJSON = new DataLoader(w, city);
        } catch (IOException e) {
            e.printStackTrace();
        }
        weatherData = weatherJSON.dataJSON;
        WeatherForecast forecast = gson.fromJson(weatherData, WeatherForecast.class);
        final String forecastString = forecast.displayForecast();
        final Activity activity = activityRef.get();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity, forecastString, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
