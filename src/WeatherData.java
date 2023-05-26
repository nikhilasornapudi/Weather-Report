package com.weatherreport.gui;

public class WeatherData {
    private String cityName;
    private double temperature;
    private double humidity;
    private double pressure;

    public String getCityName()
    {
        return this.cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public double getTemperature()
    {
        return this.temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getHumidity()
    {
        return this.humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public double getPressure()
    {
        return this.pressure;
    }

    public void setPressure(double pressure)
    {
        this.pressure = pressure;
    }
}
