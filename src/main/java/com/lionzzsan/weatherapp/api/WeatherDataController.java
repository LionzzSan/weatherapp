package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.WeatherData;
import com.lionzzsan.weatherapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/current"})
@RestController
public class WeatherDataController {
    private final WeatherService weatherService;

    public WeatherDataController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()

    public ResponseEntity<WeatherData> getWeatherData(){
        return ResponseEntity.ok(weatherService.current(UUID.randomUUID()));
    }

    @GetMapping( "/{uuid}")

    public ResponseEntity<WeatherData> getWeatherData(@PathVariable(name="uuid") UUID uuid){

        return ResponseEntity.ok(weatherService.current(uuid));
    }

}
