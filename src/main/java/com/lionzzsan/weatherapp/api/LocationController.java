package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.User;
import com.lionzzsan.weatherapp.dto.SaveLocationDto;
import com.lionzzsan.weatherapp.service.CustomUserDetailsService;
import com.lionzzsan.weatherapp.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UUID> createLocation(@RequestBody SaveLocationDto saveLocationDto) {
        UUID locationId = this.locationService.add(saveLocationDto);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.customUserDetailsService.setUserLocation(user.getId(),locationId);
        return ResponseEntity.ok(locationId);
    }

    @DeleteMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UUID> deleteLocation() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.customUserDetailsService.purgeUserLocation(user);
        return ResponseEntity.ok(locationService.delete(user.getLocation()));
    }
}



