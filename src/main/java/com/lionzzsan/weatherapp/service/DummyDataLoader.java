package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.ForecastedWeatherDataRepository;
import com.lionzzsan.weatherapp.dal.WeatherDataRepository;
import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.WeatherData;
import com.lionzzsan.weatherapp.utils.WeatherDataGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class DummyDataLoader {

    private final ScheduledExecutorService executorService;
    private final WeatherDataRepository weatherDataRepository;
    private final ForecastedWeatherDataRepository forecastedWeatherDataRepository;

    public DummyDataLoader(ScheduledExecutorService executorService,
                           WeatherDataRepository weatherDataRepository,
                           ForecastedWeatherDataRepository forecastedWeatherDataRepository) {
        this.executorService = executorService;
        this.weatherDataRepository = weatherDataRepository;
        this.forecastedWeatherDataRepository = forecastedWeatherDataRepository;
    }

    public void loadDataAsync(UUID locationId) {
        this.executorService.schedule
                (() -> this.loadDummyDataToLocation(locationId),
                        1,
                        TimeUnit.MILLISECONDS
                );
    }

    private void loadDummyDataToLocation(UUID locationId) {

        List<ForecastedWeatherData> forecastedWeatherDataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            forecastedWeatherDataList.add(
                    ForecastedWeatherData.Builder
                            .builder()
                            .locationId(locationId)
                            .forecastedTime(WeatherDataGenerator.generateOffsetDateTime((i + 1) % 7, (i + 1) % 7))
                            .build()
            );
        }

        List<WeatherData> weatherDataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            weatherDataList.add(
                    WeatherData.Builder
                            .builder()
                            .locationId(locationId)
                            .observationTime(WeatherDataGenerator.generateOffsetDateTime((i + 1) % 7, (i + 1) % 7))
                            .build()
            );
        }

        this.forecastedWeatherDataRepository.saveAll(forecastedWeatherDataList);
        this.weatherDataRepository.saveAll(weatherDataList);

    }

}
