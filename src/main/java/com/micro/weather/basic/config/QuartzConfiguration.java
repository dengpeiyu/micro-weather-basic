package com.micro.weather.basic.config;

import com.micro.weather.basic.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dengpeiyu
 * @create 2019-04-05-17:57
 */
@Configuration
public class QuartzConfiguration {

    @Value("${quartz.time}")
    private Integer quartz_time;

    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobJobDetail")
                .storeDurably().build();
    }

    @Bean
    public Trigger triggerWeatherDataSyncJob(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(quartz_time).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail()).withIdentity("triggerWeatherDataSyncJob")
                .withSchedule(simpleScheduleBuilder).build();
    }
}
