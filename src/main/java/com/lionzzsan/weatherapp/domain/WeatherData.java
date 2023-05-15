package com.lionzzsan.weatherapp.domain;

import com.lionzzsan.weatherapp.utils.WeatherDataGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "weather")
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


    public static final class Builder {
        private UUID id = UUID.randomUUID();
        private UUID locationId;
        private double temperature = WeatherDataGenerator.generateDouble(-10, 40);
        private double humidity = WeatherDataGenerator.generateDouble(30, 70);
        private double windSpeed = WeatherDataGenerator.generateDouble(0, 10);
        private double precipitation = WeatherDataGenerator.generateDouble(0, 10);
        private OffsetDateTime observationTime;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder locationId(UUID locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder temperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder humidity(double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder windSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder precipitation(double precipitation) {
            this.precipitation = precipitation;
            return this;
        }

        public Builder observationTime(OffsetDateTime observationTime) {
            this.observationTime = observationTime;
            return this;
        }

        public WeatherData build() {
            WeatherData weatherData = new WeatherData();
            weatherData.setId(id);
            weatherData.setLocationId(locationId);
            weatherData.setTemperature(temperature);
            weatherData.setHumidity(humidity);
            weatherData.setWindSpeed(windSpeed);
            weatherData.setPrecipitation(precipitation);
            weatherData.setObservationTime(observationTime);
            return weatherData;
        }
    }
}
