package com.micro.weather.basic.job;

import com.micro.weather.basic.service.ICityDataService;
import com.micro.weather.basic.service.IWeatherDataService;
import com.micro.weather.basic.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dengpeiyu
 * @create 2019-04-05-17:55
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    ICityDataService iCityDataService;
    @Autowired
    IWeatherDataService iWeatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("weather data sync job");
        List<City> cityList = iCityDataService.listCity();
   /*     for (City city : cityList) {
            iWeatherDataService.syncDataByCityId(city.getCityId());
        }
*/
        log.info("weather data sync job end!");
    }
}
