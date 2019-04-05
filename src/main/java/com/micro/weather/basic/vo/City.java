package com.micro.weather.basic.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dengpeiyu
 * @create 2019-04-05-18:22
 */
@Data
@XmlRootElement(name = "d")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;
    @XmlAttribute(name = "d2")
    private String cityName;
    @XmlAttribute(name = "d3")
    private String cityCode;
    @XmlAttribute(name = "d4")
    private String province;
}
