package com.huang.study.validation.util;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/27 13:24
 * @Description:
 */

import com.huang.study.validation.dto.ExcelTest;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 身份证号码验证
 * 1、号码的结构
 * 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。从左至右依次为：六位数字地址码，
 * 八位数字出生日期码，三位数字顺序码和一位数字校验码。
 * 2、地址码(前六位数）
 * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。
 * 3、出生日期码（第七位至十四位）
 * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
 * 4、顺序码（第十五位至十七位）
 * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号，
 * 顺序码的奇数分配给男性，偶数分配给女性。
 * 5、校验码（第十八位数）
 * （1）十七位数字本体码加权求和公式 S = Sum(Ai Wi), i = 0, , 16 ，先对前17位数字的权求和 ;
 * Ai:表示第i位置上的身份证号码数字值; Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
 * （2）计算模 Y = mod(S, 11)
 * （3）通过模( 0 1 2 3 4 5 6 7 8 9 10)得到对应的校验码 Y:1 0 X 9 8 7 6 5 4 3 2
 */
public class IdCardUtil {

    final static Map<Integer, String> zoneNum = new HashMap<Integer, String>();

    static {
        zoneNum.put(11, "北京");
        zoneNum.put(12, "天津");
        zoneNum.put(13, "河北");
        zoneNum.put(14, "山西");
        zoneNum.put(15, "内蒙古");
        zoneNum.put(21, "辽宁");
        zoneNum.put(22, "吉林");
        zoneNum.put(23, "黑龙江");
        zoneNum.put(31, "上海");
        zoneNum.put(32, "江苏");
        zoneNum.put(33, "浙江");
        zoneNum.put(34, "安徽");
        zoneNum.put(35, "福建");
        zoneNum.put(36, "江西");
        zoneNum.put(37, "山东");
        zoneNum.put(41, "河南");
        zoneNum.put(42, "湖北");
        zoneNum.put(43, "湖南");
        zoneNum.put(44, "广东");
        zoneNum.put(45, "广西");
        zoneNum.put(46, "海南");
        zoneNum.put(50, "重庆");
        zoneNum.put(51, "四川");
        zoneNum.put(52, "贵州");
        zoneNum.put(53, "云南");
        zoneNum.put(54, "西藏");
        zoneNum.put(61, "陕西");
        zoneNum.put(62, "甘肃");
        zoneNum.put(63, "青海");
        zoneNum.put(64, "宁夏");
        zoneNum.put(65, "新疆");
        zoneNum.put(71, "台湾");
        zoneNum.put(81, "香港");
        zoneNum.put(82, "澳门");
        zoneNum.put(91, "国外");
    }

    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};//校验码
    final static int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};//加权因子wi


    public boolean testType(ExcelTest excelTest, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(excelTest.getId())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("id不能为空").addConstraintViolation();
            return false;
        }
        if (StringUtils.isBlank(excelTest.getName())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name不能为空").addConstraintViolation();
            return false;
        }
        return true;
    }

    /**
     * 验证身份证号有效性
     *
     * @param idCard:身份证号
     * @return true/false
     */
    public static boolean isIdcard(String idCard) {

        //号码长度应为15位或18位
        if (idCard == null || (idCard.length() != 15 && idCard.length() != 18)) {
            return false;
        }
        //校验区位码
        if (!zoneNum.containsKey(Integer.valueOf(idCard.substring(0, 2)))) {
            return false;
        }
        //校验年份
        String year = idCard.length() == 15 ? "19" + idCard.substring(6, 8) : idCard.substring(6, 10);
        final int iyear = Integer.parseInt(year);
        if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR)) {
            return false;// 1900年的PASS，超过今年的PASS
        }
        //校验月份
        String month = idCard.length() == 15 ? idCard.substring(8, 10) : idCard.substring(10, 12);
        final int imonth = Integer.parseInt(month);
        if (imonth < 1 || imonth > 12) {
            return false;
        }
        //校验天数
        String day = idCard.length() == 15 ? idCard.substring(10, 12) : idCard.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if (iday < 1 || iday > 31) {
            return false;
        }
        //校验一个合法的年月日
        if (!isValidDate(year + month + iday)) {
            return false;
        }
        //校验位数
        int power = 0;
        final char[] cs = idCard.toUpperCase().toCharArray();
        for (int i = 0; i < cs.length; i++) {// 循环比正则表达式更快
            if (i == cs.length - 1 && cs[i] == 'X') {
                break;// 最后一位可以是X或者x
            }
            if (cs[i] < '0' || cs[i] > '9') {
                return false;
            }
            if (i < cs.length - 1) {
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
        //校验“校验码”
        if (idCard.length() == 15) {
            return true;
        }

        return cs[cs.length - 1] == PARITYBIT[power % 11];

    }

    /**
     * 判断字符串是否为日期格式(合法)
     *
     * @param inDate:字符串时间
     * @return true/false
     */
    private static boolean isValidDate(String inDate) {
        if (inDate == null) {
            return false;
        }
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");//或yyyy-MM-dd

        if (inDate.trim().length() != dataFormat.toPattern().length()) {
            return false;
        }
        dataFormat.setLenient(false);//该方法用于设置Calendar严格解析字符串;默认为true,宽松解析

        try {
            dataFormat.parse(inDate.trim());
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
