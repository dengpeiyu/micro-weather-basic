package com.micro.weather.basic.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author dengpeiyu
 * @create 2019-04-05-18:28
 */
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;
}
