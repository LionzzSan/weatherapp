package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface WeatherDataRepository extends PagingAndSortingRepository<WeatherData, UUID> {

    List<WeatherData> findAllByLocationIdAndObservationTimeLessThanEqualAndObservationTimeGreaterThanEqual(
            UUID locationId,
            OffsetDateTime endDate,
            OffsetDateTime startDate
    );

}
