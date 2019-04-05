package com.micro.weather.basic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.weather.basic.constants.CommonConst;
import com.micro.weather.basic.service.IWeatherDataService;
import com.micro.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 获取天气数据业务类
 *
 * @author dengpeiyu
 * @create 2019-04-05-13:50
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements IWeatherDataService {

    /**
     * 天气服务uri
     */
    @Value("${weather.uri}")
    private String WEATHER_URI ;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        return doGetWeather(uri);
    }


    /**
     * 获取天气数据
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {
        String strBody = null;
        //先查询缓存，如果缓存中有直接取出并返回
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(uri)) {
            strBody = ops.get(uri);
            log.info("Redis has data");
        } else {
            log.info("Redis don't has data");
            //缓存中没有，调用第三方天气服务接口，获取到数据并把数据存储到缓存中并且返回查询结果
            ResponseEntity<String> responseString = restTemplate.getForEntity(uri, String.class);
            if (responseString.getStatusCodeValue() == CommonConst.RESPONSE_SUCCESS) {
                strBody = responseString.getBody();
            }

            //将查询结果写入缓存中
            ops.set(uri,strBody,CommonConst.RedisConst.TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("Error!", e);
        }
        return null;
    }
}
