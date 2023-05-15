package com.lionzzsan.weatherapp.utils;

import java.time.OffsetDateTime;
import java.util.Random;

public class WeatherDataGenerator {

    private static final Random random = new Random();

    public static double generateDouble(int min, int max)  {
        return (min + (random.nextInt(max))) * 1.0;
    }

    public static OffsetDateTime generateOffsetDateTime(int days, int hour)  {
        var now = OffsetDateTime.now();
        var offset = now.getOffset();
        return OffsetDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth() + days, hour, 0, 0, 0, offset);
    }

}
