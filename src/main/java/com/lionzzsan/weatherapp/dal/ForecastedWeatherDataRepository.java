package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ForecastedWeatherDataRepository extends PagingAndSortingRepository<ForecastedWeatherData, UUID> {
}
