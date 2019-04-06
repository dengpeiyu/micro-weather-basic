package com.micro.weather.basic.controller;

import com.micro.weather.basic.service.ICityDataService;
import com.micro.weather.basic.service.IWeatherReportDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dengpeiyu
 * @create 2019-04-06-11:24
 */
@Controller
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    @Autowired
    private ICityDataService iCityDataService;

    @Autowired
    private IWeatherReportDataService iWeatherReportDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId , Model model){
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",iCityDataService.listCity());
        model.addAttribute("report",iWeatherReportDataService.getDataByCityId(cityId));
        return  new ModelAndView("weather/report","reportModel",model);
    }

    @GetMapping("/cityId")
    public ModelAndView getReportByCityId(){
        log.info("city start ");
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @GetMapping("/test")
    public String test(){
        log.info("city start ");
        return "weather/report";
    }
}
