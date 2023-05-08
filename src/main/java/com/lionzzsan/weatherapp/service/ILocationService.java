package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.domain.Location;

import java.util.UUID;

public interface ILocationService {

    UUID add();

    Iterable<Location> findAll(int page, int pageSize);

    UUID delete(UUID id);

    UUID findOneByUser();

}
