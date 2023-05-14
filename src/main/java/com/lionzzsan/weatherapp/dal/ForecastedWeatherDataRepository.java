package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface ForecastedWeatherDataRepository extends PagingAndSortingRepository<ForecastedWeatherData, UUID> {

    List<ForecastedWeatherData> findAllByLocationIdAndForecastedTimeLessThanEqualAndForecastedTimeGreaterThanEqual(
            UUID locationId,
            OffsetDateTime endDate,
            OffsetDateTime startDate
    );

}
