package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

class WeatherConditions {
    public int id;
    public String name;
    @SerializedName("main")
    public Map<String, Float> measurements;

    public String displayWeather() {
        String weather = name + " temperature: " + measurements.get("temp") + " degrees";
        return weather;
    }
}
