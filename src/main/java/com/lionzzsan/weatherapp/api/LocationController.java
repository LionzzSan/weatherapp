package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.dto.SaveLocationDto;
import com.lionzzsan.weatherapp.service.CustomUserDetailsService;
import com.lionzzsan.weatherapp.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(path = {"/api/v1/location"})
@RestController

public class LocationController {
    private final LocationService locationService;
private final CustomUserDetailsService customUserDetailsService;
    public LocationController(LocationService locationService, CustomUserDetailsService customUserDetailsService) {
        this.locationService = locationService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping()

    public ResponseEntity<Iterable<Location>> getLocations() {
        return ResponseEntity.ok(locationService.findAll(0,100000));
    }

    @PostMapping

    public ResponseEntity<UUID> createLocation(@RequestBody SaveLocationDto saveLocationDto) {
        UUID locationId = this.locationService.add(saveLocationDto);
        this.customUserDetailsService.setUserLocation("lionzz",locationId);
        return ResponseEntity.ok(locationId);
    }

    @DeleteMapping

    public ResponseEntity<UUID> deleteLocation() {
        return ResponseEntity.ok(UUID.randomUUID());
    }
}



