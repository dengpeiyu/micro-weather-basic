package com.micro.weather.basic.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求接口返回数据
 * @author dengpeiyu
 * @create 2019-04-05-13:43
 */
@Data
public class WeatherResponse implements Serializable{
    private Weather data;
    private Integer status;
    private String desc;

}
