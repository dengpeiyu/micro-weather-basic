package com.micro.weather.basic.controller;

import com.micro.weather.basic.service.IWeatherDataService;
import com.micro.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dengpeiyu
 * @create 2019-04-05-14:19
 */
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    @Autowired
    private IWeatherDataService iWeatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId){
        return iWeatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName){
        log.info("cityName:[{}]",cityName);
        return iWeatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
