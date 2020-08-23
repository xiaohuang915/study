package com.huang.study.hutool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/27 10:03
 */

public class CrypTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println(privateKeyBase64);
        System.out.println("-----");
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println(publicKeyBase64);

        String a = "123";

        String content = "test中文";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println(new String(key));
//构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

//加密
        byte[] encrypt1 = aes.encrypt(content);
        System.out.println(new String(encrypt1));
//解密
        byte[] decrypt1 = aes.decrypt(encrypt1);
        System.out.println(new String(decrypt1));

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
//解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKeyBase64, publicKeyBase64);

        byte[] sign1 = sign.sign(a.getBytes());

        System.out.println(sign.verify(a.getBytes(), sign1));

        //公钥加密，私钥解密

        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        System.out.println(new String(Base64.getEncoder().encode(encrypt)));
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println(new String(decrypt));


        //Junit单元测试
        //Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

        //私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        System.out.println(new String(encrypt2));
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
        System.out.println(new String(decrypt2));


    }
}
