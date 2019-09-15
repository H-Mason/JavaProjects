package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

class WeatherForecastItem {
    private List<Weather> weather;

    @SerializedName("main")
    private Map<String, Float> measurements;

    private Map<String, Float> wind;

    @SerializedName("dt_txt")
    private String time;


    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public Map<String, Float> getWind() {
        return wind;
    }

    public void setWind(Map<String, Float> wind) {
        this.wind = wind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
