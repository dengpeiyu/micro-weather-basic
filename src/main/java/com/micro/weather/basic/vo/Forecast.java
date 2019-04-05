package com.micro.weather.basic.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *  未来几天天气数据
 * @author dengpeiyu
 * @create 2019-04-05-13:35
 */
@Data
public class Forecast implements Serializable{
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

}
