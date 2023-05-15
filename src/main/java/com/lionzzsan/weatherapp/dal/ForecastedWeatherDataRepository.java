package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface ForecastedWeatherDataRepository extends JpaRepository<ForecastedWeatherData, UUID> {

    @Query("SELECT w FROM ForecastedWeatherData w WHERE w.locationId = :locationId and w.forecastedTime >= :startDate and w.forecastedTime <= :endDate")
    List<ForecastedWeatherData> findByLocationIdAndBetweenDates(
            @Param("locationId") UUID locationId,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate
    );

}
