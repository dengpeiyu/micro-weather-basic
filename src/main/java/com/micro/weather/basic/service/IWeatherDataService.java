package com.micro.weather.basic.service;

import com.micro.weather.basic.vo.WeatherResponse;

/**
 * @author dengpeiyu
 * @create 2019-04-05-13:48
 */
public interface IWeatherDataService {

    /**
     *  根据cityId查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     *  根据city名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
