package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/forecast"})
@RestController
public class ForecastedWeatherDataController {
    @GetMapping()

    public ResponseEntity<List<Location>> getForecastedWeatherData() {
        return ResponseEntity.ok(List.of(new Location()));
    }
    @GetMapping("/{uuid}")


    public ResponseEntity<List<WeatherData>> getForecastedWeatherData(@PathVariable UUID uuid){
        return ResponseEntity.ok(List.of(new WeatherData()));
    }
}
