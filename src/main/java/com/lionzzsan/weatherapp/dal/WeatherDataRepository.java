package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface WeatherDataRepository extends JpaRepository<WeatherData, UUID> {

    @Query("SELECT w FROM WeatherData w WHERE w.locationId = :locationId and w.observationTime >= :startDate and w.observationTime <= :endDate")
    List<WeatherData> findAllByLocationIdAndObservationTimeLessThanEqualAndObservationTimeGreaterThanEqual(
            @Param("locationId") UUID locationId,
            @Param("startDate") OffsetDateTime startDate,
            @Param("endDate") OffsetDateTime endDate
    );

}
