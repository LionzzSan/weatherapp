package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/location"})
@RestController

public class LocationController {
    @GetMapping()

    public ResponseEntity<List<Location>> getLocation() {
        return ResponseEntity.ok(List.of(new Location()));
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



