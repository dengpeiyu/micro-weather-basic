package com.micro.weather.basic.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  天气信息
 * @author dengpeiyu
 * @create 2019-04-05-13:27
 */
@Data
public class Weather implements Serializable {
    private String city;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
