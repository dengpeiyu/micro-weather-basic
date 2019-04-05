package com.micro.weather.basic.uitl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author dengpeiyu
 * @create 2019-04-05-18:31
 */
public class XmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz , String xmlStr) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        //XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(xmlStr);
        Object xmlObject = unmarshaller.unmarshal(reader);
        if (reader !=null ){
            reader.close();
        }
        return xmlObject;
    }
}
