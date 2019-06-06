package com.huang.study.test.entity;

import org.springframework.core.io.ClassPathResource;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAUtil {

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) {
        try {
            //java默认"RSA"="RSA/ECB/PKCS1Padding"
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        String tx = "test";
        ClassPathResource classPathResource = new ClassPathResource("pri.key");
        InputStream inputStream = classPathResource.getInputStream();
        PrivateKey privateKey = SignUtil.loadPrivateKey(inputStream, "PKCS8");

        ClassPathResource pub = new ClassPathResource("pub.key");
        InputStream pubInputStream = pub.getInputStream();
        PublicKey publicKey = SignUtil.loadPublicKey(pubInputStream);

        byte[] encrypt = encrypt(tx.getBytes(), publicKey);
        String s = new String(encrypt);
        System.out.println("加密：----" + s);

        byte[] decrypt = decrypt(s.getBytes(), privateKey);
        System.out.println("解密：" + new String(decrypt));
    }
}


