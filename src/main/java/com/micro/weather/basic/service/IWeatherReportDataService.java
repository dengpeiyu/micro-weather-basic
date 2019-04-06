package com.micro.weather.basic.service;

import com.micro.weather.basic.vo.Weather;

/**
 * @author dengpeiyu
 * @create 2019-04-06-11:30
 */
public interface IWeatherReportDataService {

    /**
     * 根据城市ID获取城市数据
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
