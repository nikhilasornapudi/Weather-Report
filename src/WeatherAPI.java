package com.weatherreport.gui;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI
{
    public static WeatherData getWeatherData(String cityName) {
        String apiKey = "0cd23ce7ca4390f297c4ee7d2ab9c1c6";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;

        try {
            // Make an HTTP request to the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.toString());
            JSONObject main = (JSONObject) json.get("main");
            double temperatureInKelvin = ((Number) main.get("temp")).doubleValue();
            double temperatureInFahrenheit = (temperatureInKelvin - 273.15) * 1.8 + 32;
            double temperature = Double.parseDouble(String.format("%.2f", temperatureInFahrenheit));
            double humidity = ((Number) main.get("humidity")).doubleValue();
            double pressure = ((Number) main.get("pressure")).doubleValue();

            // Create a new WeatherData object
            WeatherData weatherData = new WeatherData();
            weatherData.setCityName(cityName);
            weatherData.setTemperature(temperature);
            weatherData.setHumidity(humidity);
            weatherData.setPressure(pressure);

            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

