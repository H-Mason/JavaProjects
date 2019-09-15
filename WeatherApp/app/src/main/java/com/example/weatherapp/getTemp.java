package com.example.weatherapp;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.WeakReference;

import static android.content.ContentValues.TAG;

public class getTemp implements Runnable {
    String city;
    String weatherData;
    String w;
    private WeakReference<Activity> activityRef;
    public getTemp(String cityName, Activity activity) {
        city = cityName;
        w = "weather";
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
        WeatherConditions weather = gson.fromJson(weatherData, WeatherConditions.class);
        final String weatherString = weather.displayWeather();
        final Activity activity = activityRef.get();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity, weatherString, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
