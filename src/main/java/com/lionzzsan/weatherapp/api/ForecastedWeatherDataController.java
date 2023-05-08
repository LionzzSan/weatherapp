package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.WeatherData;
import com.lionzzsan.weatherapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ResponseEntity<ForecastedWeatherData> getForecastedWeatherData() {
        return ResponseEntity.ok(weatherService.forecast(UUID.randomUUID()));
    }
    @GetMapping("/{uuid}")


    public ResponseEntity<ForecastedWeatherData> getForecastedWeatherData(@PathVariable UUID uuid){
        return ResponseEntity.ok(weatherService.forecast(uuid));
    }
}
