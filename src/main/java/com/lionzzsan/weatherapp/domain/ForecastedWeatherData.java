package com.lionzzsan.weatherapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity(name = "forecasted_weather_data")
public class ForecastedWeatherData {
    @Id
    @Column(name = "id",unique = true)
    private UUID id;
    @Column(name = "high_temp")
    private double highTemp;
    @Column(name = "low_temp")
    private double lowTemp;
    @Column(name = "precipitation")
    private double precipitation;
    @Column(name = "forecasted_time",columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime forecastedTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
