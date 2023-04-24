package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(path = {"/api/v1/location"})
@RestController

public class LocationController {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Location> getLocation() {
        return ResponseEntity.ok(new Location());
    }

}



