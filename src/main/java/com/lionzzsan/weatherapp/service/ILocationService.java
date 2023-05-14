package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.dto.SaveLocationDto;

import java.util.UUID;

public interface ILocationService {

    UUID add(SaveLocationDto saveLocationDto);

    Iterable<Location> findAll(int page, int pageSize);

    UUID delete(UUID id);

    UUID findOneByUser();

}
