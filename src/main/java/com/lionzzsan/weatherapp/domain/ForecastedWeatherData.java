package com.lionzzsan.weatherapp.domain;

import com.lionzzsan.weatherapp.utils.WeatherDataGenerator;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "forecasted_weather_data")
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
    @Column(name = "location_id")
    private UUID locationId;

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
        Assert.notNull(forecastedTime, "forecastedTime of ForecastedWeatherData must not be null");
        this.forecastedTime = forecastedTime;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }


    public static final class Builder {
        private UUID id = UUID.randomUUID();
        private double highTemp = WeatherDataGenerator.generateDouble(20, 40);
        private double lowTemp = WeatherDataGenerator.generateDouble(-10, 20);
        private double precipitation = WeatherDataGenerator.generateDouble(0, 10);
        private OffsetDateTime forecastedTime;
        private UUID locationId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder highTemp(double highTemp) {
            this.highTemp = highTemp;
            return this;
        }

        public Builder lowTemp(double lowTemp) {
            this.lowTemp = lowTemp;
            return this;
        }

        public Builder precipitation(double precipitation) {
            this.precipitation = precipitation;
            return this;
        }

        public Builder forecastedTime(OffsetDateTime forecastedTime) {
            this.forecastedTime = forecastedTime;
            return this;
        }

        public Builder locationId(UUID locationId) {
            this.locationId = locationId;
            return this;
        }

        public ForecastedWeatherData build() {
            ForecastedWeatherData forecastedWeatherData = new ForecastedWeatherData();
            forecastedWeatherData.setId(id);
            forecastedWeatherData.setHighTemp(highTemp);
            forecastedWeatherData.setLowTemp(lowTemp);
            forecastedWeatherData.setPrecipitation(precipitation);
            forecastedWeatherData.setForecastedTime(forecastedTime);
            forecastedWeatherData.setLocationId(locationId);
            return forecastedWeatherData;
        }
    }
}
