package com.example.weatherapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

class DataLoader {
    String url = "https://api.openweathermap.org/data/2.5/";
    String charset = "UTF-8";
    String q;
    String apiKey = "c7e8bb48a7293ba1ce18b3fbb263cf95";
    String w;
    String dataJSON;

    public DataLoader(String in, String city) throws IOException {
        q = city;
        w = in;
        String query = String.format("q=%s&apiKey=%s",
                URLEncoder.encode(q, charset),
                URLEncoder.encode(apiKey, charset));

        URLConnection connection = new URL(url + w + "?" + query + "&units=imperial").openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();

        Scanner newScanner = new Scanner(response);
        dataJSON = newScanner.useDelimiter("\\A").next();
    }
}
