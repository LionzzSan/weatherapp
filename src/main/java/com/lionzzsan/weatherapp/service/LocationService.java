package com.lionzzsan.weatherapp.service;

import com.lionzzsan.weatherapp.dal.LocationDataRepository;
import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.dto.SaveLocationDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LocationService implements ILocationService{
    private final LocationDataRepository locationDataRepository;

    public LocationService(LocationDataRepository locationDataRepository) {
        this.locationDataRepository = locationDataRepository;
    }

    @Override
    public UUID add(SaveLocationDto saveLocationDto) {
        Location location = new Location();
        location.setLatitude(saveLocationDto.getLatitude() );
        location.setLongitude(saveLocationDto.getLatitude());
        location.setName(saveLocationDto.getName());
        location.setId(UUID.randomUUID());
        return locationDataRepository.save(location).getId();
    }

    @Override
    public Iterable<Location> findAll(int page, int pageSize) {
        var pageRequest = PageRequest.of(page,pageSize);
        return locationDataRepository.findAll(pageRequest);
    }

    @Override
    public UUID delete(UUID id) {
       locationDataRepository.deleteById(id);
       return id;
    }

    @Override
    public UUID findOneByUser() {
        return null;
    }
}
