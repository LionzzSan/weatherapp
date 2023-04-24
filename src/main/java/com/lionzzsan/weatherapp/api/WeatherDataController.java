package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.Location;
import com.lionzzsan.weatherapp.domain.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(path = {"/api/v1/weather"})
@RestController
public class WeatherDataController {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<WeatherData> getWeatherData(){
        return ResponseEntity.ok(new WeatherData());
    }

}
