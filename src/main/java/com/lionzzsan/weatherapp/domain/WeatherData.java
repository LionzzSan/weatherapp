package com.lionzzsan.weatherapp.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

public class WeatherData {
    private UUID id;

    private UUID locationId;

    private double temperature;

    private double humidity;

    private double windSpeed;

    private double precipitation;

    private OffsetDateTime observationTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public OffsetDateTime getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(OffsetDateTime observationTime) {
        this.observationTime = observationTime;
    }
}
