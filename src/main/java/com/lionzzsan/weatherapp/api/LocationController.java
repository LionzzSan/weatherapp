package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/location"})
@RestController

public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping()

    public ResponseEntity<Iterable<Location>> getLocations() {
        return ResponseEntity.ok(locationService.findAll(0,100000));
    }

    @PostMapping

    public ResponseEntity<Location> createLocation() {
        return ResponseEntity.ok(new Location());
    }

    @DeleteMapping

    public ResponseEntity<UUID> deleteLocation() {
        return ResponseEntity.ok(UUID.randomUUID());
    }
}



