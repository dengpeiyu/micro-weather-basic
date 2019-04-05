package com.micro.weather.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author dengpeiyu
 * @create 2019-04-05-14:27
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder templateBuilder;

    @Bean
    public RestTemplate restTemplate(){
        return  templateBuilder.build();
    }
}
