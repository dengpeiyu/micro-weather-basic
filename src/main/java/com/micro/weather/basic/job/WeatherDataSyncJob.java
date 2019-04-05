package com.micro.weather.basic.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author dengpeiyu
 * @create 2019-04-05-17:55
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("weather data sync job");
    }
}
