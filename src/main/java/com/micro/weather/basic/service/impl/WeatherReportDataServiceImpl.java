package com.micro.weather.basic.service.impl;

import com.micro.weather.basic.service.IWeatherDataService;
import com.micro.weather.basic.service.IWeatherReportDataService;
import com.micro.weather.basic.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dengpeiyu
 * @create 2019-04-06-11:32
 */
@Service
public class WeatherReportDataServiceImpl implements IWeatherReportDataService {

    @Autowired
    private IWeatherDataService iWeatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        return iWeatherDataService.getDataByCityId(cityId).getData();
    }
}
