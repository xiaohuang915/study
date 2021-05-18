package com.huang.study.xml;

import com.bocd.gwsign.SignUtils;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/18 16:26
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tea")
public class Tea {
    @XmlElement(name = "id")
    private String id;

    public static void main(String[] args) throws Exception {
        //私钥存放路径
        String privateKeyPath = "D:\\documen\\成都银行\\pri.pfx";
        //公钥存放路径
        String publicKeyPath = "D:\\documen\\成都银行\\per.cer";
        //待签名字符串
        String content = "campusName=成华校区小学部&gradeName";
        //编码
        String charsetUTF8 = "UTF-8";
        //私钥密码
        String password = "123456";
        //私钥文件流
        FileInputStream fileInputStreamPri = new FileInputStream(privateKeyPath);
        //公钥文件流
        FileInputStream fileInputStreamPub = new FileInputStream(publicKeyPath);


        String sha256Sign = SignUtils.rsa256Sign(content, null, fileInputStreamPri,password);
        System.out.println("明文："+content);
        System.out.println("签名后：" + sha256Sign);
        boolean sha256SignVerifyPlain = SignUtils.rsa256VerifySign(content, sha256Sign,charsetUTF8,fileInputStreamPub);
        System.out.println("验签结果："+ sha256SignVerifyPlain);
    }

}
