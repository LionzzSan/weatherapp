package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface WeatherDataRepository extends PagingAndSortingRepository<WeatherData, UUID> {
}
