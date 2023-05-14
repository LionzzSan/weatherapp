package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.ForecastedWeatherDataRepository;
import com.lionzzsan.weatherapp.dal.WeatherDataRepository;
import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class WeatherService implements IWeatherService{

    private final WeatherDataRepository weatherDataRepository;
    private final ForecastedWeatherDataRepository forecastedWeatherDataRepository;

    public WeatherService(WeatherDataRepository weatherDataRepository, ForecastedWeatherDataRepository forecastedWeatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
        this.forecastedWeatherDataRepository = forecastedWeatherDataRepository;
    }

    @Override
    public WeatherData current(UUID locationId) {
        return null;
    }

    @Override
    public ForecastedWeatherData forecast(UUID locationId) {
        return null;
    }
}
