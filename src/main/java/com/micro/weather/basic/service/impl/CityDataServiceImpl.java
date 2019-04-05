package com.micro.weather.basic.service.impl;

import com.micro.weather.basic.service.ICityDataService;
import com.micro.weather.basic.uitl.XmlBuilder;
import com.micro.weather.basic.vo.City;
import com.micro.weather.basic.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * City Data Service Impl
 * @author dengpeiyu
 * @create 2019-04-05-19:17
 */
@Service
@Slf4j
public class CityDataServiceImpl implements ICityDataService {

    @Override
    public List<City> listCity() {
        //读取文件
        Resource resource = new ClassPathResource("citylist.xml");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line=bufferedReader.readLine())!=null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();

            //将XML转为Java对象
            CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,stringBuffer.toString());
            return cityList.getCityList();
        } catch (IOException e) {
           log.error("city file reader error!",e);
        } catch (JAXBException e) {
            log.error("data parse error!",e);
        }
        return null;
    }
}
