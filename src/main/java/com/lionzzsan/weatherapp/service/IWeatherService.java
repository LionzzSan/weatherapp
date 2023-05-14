package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;

import java.util.List;
import java.util.UUID;

public interface IWeatherService {

    List<WeatherData> current(UUID locationId);

    List<ForecastedWeatherData> forecast(UUID locationId);

}
