package com.huang.study.test.entity;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.UUID;


/**
 * AES加密CBC模式
 * 
 * @author zhangxin
 *
 */
public class AesCBC {

	private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
	// 加密方式
	private static final String KEY_ALGORITHM = "AES";


	private static final String VI_STR = "6DA0557C5119454A";

	/**
	 * 生成AES密钥,密钥大于16位截取16位，小于16位末尾补0
	 * 
	 * @return SecretKeySpec AES密钥
	 * @throws UnsupportedEncodingException
	 */
	public static String createSecretKey() throws UnsupportedEncodingException {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		StringBuilder sb = new StringBuilder();
		sb.append(uuid);
		while (sb.length() < 16) {
			sb.append("0");
		}
		if (sb.length() > 16) {
			sb.setLength(16);
		}
		return sb.toString();
	}

	/**
	 * 生成AES加密器初始化向量，偏移量参数大于16位截取16位，小于16位末尾补0
	 * 
	 * @param ivStr
	 *            偏移量
	 * @return IvParameterSpec AES加密器初始化向量
	 */
	public static IvParameterSpec createIVSpec(String ivStr) {
		byte[] data = null;
		if (ivStr == null) {
			ivStr = "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ivStr);
		while (sb.length() < 16) {
			sb.append("0");
		}
		if (sb.length() > 16) {
			sb.setLength(16);
		}

		try {
			data = sb.toString().getBytes("utf-8");
		} catch (Exception ex) {
			return null;
		}
		return new IvParameterSpec(data);
	}

	/**
	 * 将要加密的字节数组经过AES加密后，再由Base64编码成字符串返回
	 * 
	 * @param content
	 *            要加密内容
	 * @param key
	 *            密钥
	 * @return String 加密后的字符串
	 */
	public static String encryptAES(byte[] content, String key) {
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_MODE);
			cipher.init(Cipher.ENCRYPT_MODE,
					new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM),
					createIVSpec(VI_STR));
			byte[] bytes = cipher.doFinal(content);
			result = encodeBase64(bytes);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 将Base64编码的字符串去掉回车换行后解码，进行AES解密
	 * 
	 * @param content
	 *            要解密的Base64编码的字符串
	 * @param key
	 *            密钥
	 * @return byte[] 解密后的字节数组
	 */
	public static byte[] decryptAES(String content, String key) {
		byte[] data = null;
		try {
			content = Conver.replaceBaseStr(content);
			data = decodeBase64(content);
			Cipher cipher = Cipher.getInstance(CIPHER_MODE);
			cipher.init(Cipher.DECRYPT_MODE,
					new SecretKeySpec(key.getBytes("utf-8"), KEY_ALGORITHM),
					createIVSpec(VI_STR));
			byte[] result = cipher.doFinal(data);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Base64编码
	 * 
	 * @param conent
	 *            要编码的字节数组
	 * @return String 编码后的字符串
	 */
	public static String encodeBase64(byte[] conent) {
		Base64 base64 = new Base64();
		byte[] bytes = base64.encode(conent);
		String s = null;
		try {
			s = new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * Base64解码
	 * 
	 * @param conent
	 *            要解码的字符串
	 * @return byte[] 解码后的字节数组
	 */
	public static byte[] decodeBase64(String conent) {
		byte[] bytes = null;
		try {
			bytes = conent.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Base64 base64 = new Base64();
		bytes = base64.decode(bytes);
		return bytes;
	}


}
