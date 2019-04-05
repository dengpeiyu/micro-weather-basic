package com.micro.weather.basic.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *  昨天天气数据
 * @author dengpeiyu
 * @create 2019-04-05-13:34
 */
@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
