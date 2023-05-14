package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.ForecastedWeatherData;
import com.lionzzsan.weatherapp.domain.User;
import com.lionzzsan.weatherapp.service.CustomUserDetailsService;
import com.lionzzsan.weatherapp.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/forecast"})
@RestController
public class ForecastedWeatherDataController {
    private final WeatherService weatherService;
    private final CustomUserDetailsService customUserDetailsService;
    public ForecastedWeatherDataController(WeatherService weatherService, CustomUserDetailsService customUserDetailsService) {
        this.weatherService = weatherService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping()

    public ResponseEntity<List<ForecastedWeatherData>> getForecastedWeatherData() {
       User user = (User) this.customUserDetailsService.loadUserByUsername("lionzz");
        return ResponseEntity.ok(weatherService.forecast(user.getLocation()));
    }
    @GetMapping("/{uuid}")


    public ResponseEntity<List<ForecastedWeatherData>> getForecastedWeatherData(@PathVariable UUID uuid){
        return ResponseEntity.ok(weatherService.forecast(uuid));
    }
}
