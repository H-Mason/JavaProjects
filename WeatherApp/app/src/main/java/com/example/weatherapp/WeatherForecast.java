package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class WeatherForecast {
    @SerializedName("list")
    private List<WeatherForecastItem> forecastItems;

    public List<WeatherForecastItem> getForecastItems() {
        return forecastItems;
    }

    public void setForecastItems(List<WeatherForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }

    public String displayForecast() {
        String fullString = "";
        for (WeatherForecastItem item: forecastItems) {

            String weatherString = "";
            if (item.getWeather().size() > 0) {
                weatherString = item.getWeather().get(0).getFullDesc();
            }
            fullString += "Date/Time: " + item.getTime();

            fullString += "Temperature: " + item.getMeasurements().get("temp");
            fullString += "Description: " + weatherString;
            fullString += "Wind Speed: " + item.getWind().get("speed");
        }
        return fullString;
    }
}
