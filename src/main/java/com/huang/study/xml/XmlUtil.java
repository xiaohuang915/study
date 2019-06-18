package com.huang.study.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/18 16:24
 */
public class XmlUtil {

    public static String beanToXml(Object obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    public static <T> T xmlToBean(Class<T> clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return (T) xmlObject;
    }

    public static void main(String[] args) throws JAXBException {
        Cla<Stu,Tea> cla = new Cla();

        Stu stu = new Stu();
        stu.setName("test");
        cla.setSs(stu);

        Tea tea = new Tea();
        tea.setId("123");
        cla.setTt(tea);





        System.out.println(beanToXml(cla));
    }
}
