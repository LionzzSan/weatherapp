package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.ForecastedWeatherDataRepository;
import com.lionzzsan.weatherapp.dal.WeatherDataRepository;
import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
    public List<WeatherData> current(UUID locationId) {
        return weatherDataRepository.findAllByLocationIdAndObservationTimeLessThanEqualAndObservationTimeGreaterThanEqual(
                locationId,OffsetDateTime.now().truncatedTo(ChronoUnit.HOURS), OffsetDateTime.now().plusDays(1).truncatedTo(ChronoUnit.HOURS)
        );
    }

    @Override
    public List<ForecastedWeatherData> forecast(UUID locationId) {
        return this.forecastedWeatherDataRepository.findAllByLocationIdAndForecastedTimeLessThanEqualAndForecastedTimeGreaterThanEqual(
                locationId, OffsetDateTime.now(), OffsetDateTime.now().plusDays(7)
        );
    }
}
