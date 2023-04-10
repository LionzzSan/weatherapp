package com.lionzzsan.weatherapp.domain;

import java.time.OffsetDateTime;

public class ForecastedWeatherData {
    private double highTemp;

    private double lowTemp;

    private double precipitation;

    private OffsetDateTime forecastedTime;

    public double getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(double highTemp) {
        this.highTemp = highTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(double lowTemp) {
        this.lowTemp = lowTemp;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public OffsetDateTime getForecastedTime() {
        return forecastedTime;
    }

    public void setForecastedTime(OffsetDateTime forecastedTime) {
        this.forecastedTime = forecastedTime;
    }
}
