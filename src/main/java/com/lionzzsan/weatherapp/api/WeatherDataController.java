package com.lionzzsan.weatherapp.api;

import com.lionzzsan.weatherapp.domain.User;
import com.lionzzsan.weatherapp.domain.WeatherData;
import com.lionzzsan.weatherapp.service.CustomUserDetailsService;
import com.lionzzsan.weatherapp.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = {"/api/v1/weather/current"})
@RestController
public class WeatherDataController {
    private final WeatherService weatherService;
    private final CustomUserDetailsService customUserDetailsService;
    public WeatherDataController(WeatherService weatherService, CustomUserDetailsService customUserDetailsService) {
        this.weatherService = weatherService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping()

    public ResponseEntity<List<WeatherData>> getWeatherData(){
        User user = (User)this.customUserDetailsService.loadUserByUsername("lionzz");
        return ResponseEntity.ok(weatherService.current(user.getLocation()));
    }

    @GetMapping( "/{uuid}")

    public ResponseEntity<List<WeatherData>> getWeatherData(@PathVariable(name="uuid") UUID uuid){

        return ResponseEntity.ok(weatherService.current(uuid));
    }

}
