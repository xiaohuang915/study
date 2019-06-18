package com.huang.study.test;

import com.huang.study.test.entity.AccountOpenNotifyBodyRequestVo;
import com.huang.study.test.entity.AccountOpenNotifyHeadRequestVo;
import com.huang.study.test.entity.AccountOpenNotifyRequestVo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-15 16:44
 */
public class Test {

    /**
     * envelope : {"head":{"sysId":"gh00001","charset":"UTF-8","timestamp":"20190308133558","serialValue":"2019030800000000004","version":"3.0","orgcode":"gh01"},"body":{"serviceCode":"B1006_0001_00","parameters":{"ZHLX":"1","ZCLY":"2023","SJHM":"135*******","SHBH":"008999988","SHHYID":"1234443"}}}
     * signature :
     */


//    public static void main(String[] args) throws Exception {
//        PayMentRequestVo payMentRequestVo = new PayMentRequestVo();
//        HeadRequestVo headRequestVo = new HeadRequestVo();
//        headRequestVo.setAgentCode("29028001");
//        headRequestVo.setReqType("0200");
//        headRequestVo.setTrnType("PAY000");
//        headRequestVo.setTxSn("12346");
//        PayMentBodyRequestVo payMentBodyRequestVo = new PayMentBodyRequestVo();
//        payMentBodyRequestVo.setMerchantNo("456");
//        payMentBodyRequestVo.setCardNo("46468364646464");
//        payMentBodyRequestVo.setTerminalChnl("00");
//        payMentBodyRequestVo.setOrderNo("1346");
//        payMentBodyRequestVo.setAgrmtNo("13245");
//        payMentBodyRequestVo.setCurCode("001");
//        payMentBodyRequestVo.setOrderAmount("100");
//        payMentBodyRequestVo.setOrderTime("201905311640");
//        payMentBodyRequestVo.setOrderNote("");
//        payMentRequestVo.setPayMentBodyRequestVo(payMentBodyRequestVo);
//        payMentRequestVo.setHeadRequestVo(headRequestVo);
//        String s = Test.beanToXml(payMentRequestVo);
//        Map<String, String> map = new HashMap<>();
//        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
//        PrivateKey privateKey = SignUtil.loadPrivateKey(FileUtil.loadInputStreamFromPath("pri.key"), "PKCS8");
//        PublicKey publicKey = SignUtil.loadPublicKey(FileUtil.loadInputStreamFromPath("pub.key"));
//        byte[] pkcs8s = SignUtil.sign(inputStream, privateKey);
//
//        String secretKey = AesCBC.createSecretKey();
//        String s1 = AesCBC.encryptAES(pkcs8s, secretKey);
//        String s3 = Base64.encodeBase64String(RSAUtil.encrypt(secretKey.getBytes(), publicKey));
//        map.put("body", s1);
//        map.put("skey", s3);
//        System.out.println(JSON.toJSONString(map));
//        String decrypt = new String(RSAUtil.decrypt(Base64.decodeBase64(s3), privateKey));
//
//        byte[] bytes = AesCBC.decryptAES(s1, decrypt);
//        String s2 = new String(bytes);
//        SignUtil.verifySign(s2.getBytes(),publicKey);
//        PayMentRequestVo payMentRequestVo1 = xmlToBean(PayMentRequestVo.class, s2);
//        System.out.println(JSON.toJSONString(payMentRequestVo1));
//
////        PayMentRequestVo payMentRequestVo1 = convertXmlStrToObject(PayMentRequestVo.class, s);
////        System.out.println(JSON.toJSONString(payMentRequestVo1));
////        B b = new B();
////        b.setName("名称");
////        D d = BeanUtil.beanCopy(b, D.class, false);
////        System.out.println(JSON.toJSONString(d));
////        List<A> list = new ArrayList<>();
////
////        A a = new A();
////        a.setId("111");
////        a.setAmount(1L);
////        list.add(a);
////
////        A a1 = new A();
////        a1.setId("111");
////        a1.setAmount(2L);
////        list.add(a1);
////
////        A a3 = new A();
////        a3.setId("222");
////        a3.setAmount(3L);
////        list.add(a3);
////
////        list.stream().collect(Collectors.groupingBy(A::getId)).forEach((k, v) -> {
////            if (v.size() > 1) {
////                v.forEach(b -> {
////                    b.setError("错误");
////                    System.out.println(b);
////                });
////            }
////        });
////        System.out.println(list);
//
////        String s = JSON.toJSONString(list);
////        System.out.println(s);
////        System.out.println(JSON.parseArray(s, A.class));
////        JSONArray objects = JSONObject.parseArray(s);
////        System.out.println(objects);
//
//
////        A a1 = new A();
////        a1.setAmount(1L);
////        list.add(a1);
////
////        System.out.println(JSON.toJSONString(list));
////
////        list.stream().filter(b -> b.getAmount() > 0).collect(Collectors.toList());
////        System.out.println("过滤后 " + JSON.toJSONString(list));
//    }
    public static void main(String[] args) throws JAXBException {
        AccountOpenNotifyRequestVo requestVo = new AccountOpenNotifyRequestVo();

        AccountOpenNotifyHeadRequestVo headRequestVo = new AccountOpenNotifyHeadRequestVo();
//        headRequestVo.setServiceId("123");
        headRequestVo.setSystemId("system");
        AccountOpenNotifyBodyRequestVo bodyRequestVo = new AccountOpenNotifyBodyRequestVo();
//        bodyRequestVo.setAccChannelFlag("456");
        bodyRequestVo.setCertNo("123");
        bodyRequestVo.setAddress("地址11");
        requestVo.setHeadRequestVo(headRequestVo);
        requestVo.setBodyRequestVo(bodyRequestVo);
        System.out.println(beanToXml(requestVo));
    }

    public static <T> void get(T t) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getName());
            System.out.println(declaredField.get(t));
            map.put(declaredField.getName(), declaredField.get(t));
            stringBuilder.append(declaredField.getName()).append("=").append(declaredField.get(t)).append("&");
        }
        String signSrc = stringBuilder.toString();
        if (signSrc.endsWith("&")) {
            signSrc = signSrc.substring(0, signSrc.length() - 1);
        }
        System.out.println(signSrc);
        map.forEach((k, v) -> {
            System.out.println("k=" + k + "v=" + v);
        });
    }

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


}
