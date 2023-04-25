package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/current"})
@RestController
public class WeatherDataController {
    @GetMapping()

    public ResponseEntity<List<WeatherData>> getWeatherData(){
        return ResponseEntity.ok(List.of(new WeatherData()));
    }

    @GetMapping( "/{uuid}")

    public ResponseEntity<List<WeatherData>> getWeatherData(@PathVariable(name="uuid") UUID uuid){

        return ResponseEntity.ok(List.of(new WeatherData()));
    }

}
