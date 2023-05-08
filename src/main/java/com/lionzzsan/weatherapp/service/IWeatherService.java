package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;

import java.util.UUID;

public interface IWeatherService {

    WeatherData current(UUID locationId);

    ForecastedWeatherData forecast(UUID locationId);

}
