package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.LocationDataRepository;
import com.lionzzsan.weatherapp.dal.WeatherDataRepository;
import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class WeatherService implements IWeatherService{
    private final WeatherDataRepository weatherDataRepository;

    public WeatherService(WeatherDataRepository weatherDataRepository, ForecastedWeatherData forecastedWeatherData) {
        this.weatherDataRepository = weatherDataRepository;
        this.forecastedWeatherData = forecastedWeatherData;
    }

    private final ForecastedWeatherData forecastedWeatherData;
    @Override
    public WeatherData current(UUID locationId) {
        return null;
    }

    @Override
    public ForecastedWeatherData forecast(UUID locationId) {
        return null;
    }
}
