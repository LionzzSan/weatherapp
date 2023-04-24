package com.lionzzsan.weatherapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity(name = "weather")

public class WeatherData {
    @Id
    @Column(name = "id",unique = true)

    private UUID id;
    @Column(name = "location_id")
    private UUID locationId;
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "humidity")
    private double humidity;
    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "precipitation")
    private double precipitation;
    @Column(name = "observation_time",columnDefinition = "TIMESTAMP WITH TIME ZONE")
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
