package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.User;
import com.lionzzsan.weatherapp.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/forecast"})
@RestController
public class ForecastedWeatherDataController {

    private final WeatherService weatherService;

    public ForecastedWeatherDataController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ForecastedWeatherData>> getForecastedWeatherData() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(weatherService.forecast(user.getLocation()));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<List<ForecastedWeatherData>> getForecastedWeatherData(@PathVariable UUID uuid) {
        return ResponseEntity.ok(weatherService.forecast(uuid));
    }
}
