package com.huang.study.test.entity;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Conver {

    public static String IntToAsc(int i) {
        return String.valueOf(i);
    }

    public static String AscToHex(String s) {
        return BinToHex(s.getBytes());
    }

    public static int AscToInt(String s) {
        return Integer.parseInt(s);
    }

    public static int BinToInt(byte[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            ret = ret * 256 + ((arr[i] > 0) ? ((int) arr[i]) : ((int) arr[i] + 256));
        }
        return ret;
    }

    public static byte[] HexToBin(String hexString) {
        ArrayList<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i < hexString.length(); i += 2) {
            char a = hexString.charAt(i);
            char b = hexString.charAt(i + 1);
            int ia = getIntValue(a);
            int ib = getIntValue(b);
            list.add(Byte.valueOf(Integer.valueOf(ia * 16 + ib).byteValue()));
        }
        list.trimToSize();
        byte[] ret = new byte[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ret[i] = list.get(i).byteValue();
        }
        return ret;

    }

    public static String BinToHex(byte[] arr) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < arr.length; ++i) {
            int v = arr[i];
            if (v < 0) {
                v += 256;
            }
            int a = v / 16;
            int b = v % 16;
            list.add(Character.valueOf(getHexValue(a)));
            list.add(Character.valueOf(getHexValue(b)));
        }
        list.trimToSize();
        char[] cArr = new char[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            cArr[i] = list.get(i).charValue();
        }

        String ret = new String(cArr);
        return ret;

    }

    private static int getIntValue(char c) {
        switch (c) {
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                return (int) (c - '0');

        }
    }


    private static char getHexValue(int c) {
        String s = Integer.toHexString(c).toUpperCase();
        return s.charAt(0);
    }

    public static byte[] getHeadBuff(int dylen, int len, String type) {
        if (dylen == 0) {
            return new byte[0];
        }
        if ("NUM".equals(type)) {
            StringBuilder lStr = new StringBuilder();
            lStr.append(len);
            lStr.trimToSize();
            lStr.reverse();
            for (int i = 0, j = dylen - lStr.length(); i < j; ++i) {
                lStr.append('0');
            }
            lStr.trimToSize();
            return lStr.reverse().toString().getBytes();
        }
        return new byte[0];
    }

    /**
     * Base64编码
     *
     * @param bytes 要编码的字节数组
     * @return String 编码后的字符串
     */
    public static String encodeBase64(byte[] bytes) {

        return Base64.encodeBase64String(bytes);
    }

    /**
     * Base64解码
     *
     * @param conent 要解码的字符串
     * @return byte[] 解码后的字节数组
     */
    public static byte[] decodeBase64(String conent) {
        byte[] bytes = null;
        try {
            bytes = conent.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            bytes = conent.getBytes(Charset.defaultCharset());
        }
        bytes = Base64.decodeBase64(bytes);
        return bytes;
    }

    /**
     * 如果参数为null，返回""，否则原样返回
     *
     * @param str
     * @return
     */
    public static String getString(String str) {
        return str == null ? null : str;
    }


    /**
     * 如果字符串中包含了回车、和换行符，则替换成空字符
     * 去掉base64编码时出现的回车和换行符
     *
     * @param arg
     * @return
     */
    public static String replaceBaseStr(String arg) {
        return getString(arg).replaceAll("[\\n\\r]", "");
    }

}