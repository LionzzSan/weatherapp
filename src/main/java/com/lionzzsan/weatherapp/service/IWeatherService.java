package com.lionzzsan.weatherapp.service;

import java.util.UUID;

public interface IWeatherService {

    Object current(UUID locationId);

    Object forecast(UUID locationId);

}
