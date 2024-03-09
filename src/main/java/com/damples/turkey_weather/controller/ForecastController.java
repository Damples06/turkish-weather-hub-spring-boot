package com.damples.turkey_weather.controller;

import com.damples.turkey_weather.service.ForecastService;
import com.damples.turkey_weather.model.Forecast;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ForecastController {
    private final ForecastService forecastService;

    // This method is used to get the forecast data of the area.
    @GetMapping("/{provinceName}/forecast")
    public ResponseEntity<Forecast> getForecastData(@PathVariable String provinceName) throws IOException, InterruptedException {
        Forecast forecast = forecastService.getForecastData(provinceName);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }
}