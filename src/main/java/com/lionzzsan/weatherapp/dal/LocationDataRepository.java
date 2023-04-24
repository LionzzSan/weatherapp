package com.lionzzsan.weatherapp.dal;

import com.lionzzsan.weatherapp.domain.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface LocationDataRepository extends PagingAndSortingRepository<Location, UUID> {
}
