package com.huang.study.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/9 13:52
 * @Description:
 */
public class NumUtil {
    /**
     * 计算每人获得红包金额;最小每人0.01元
     *
     * @param mmm    红包总额
     * @param number 人数
     * @return
     */
    public static List<BigDecimal> math(BigDecimal mmm, int number) {
        if (mmm.doubleValue() < number * 0.01) {
            return null;
        }

        //当平均金额=一分钱的时候所有人都一样;
        BigDecimal divideMoney = mmm.divide(BigDecimal.valueOf(number), 2, BigDecimal.ROUND_DOWN);
            if (divideMoney.compareTo(BigDecimal.valueOf(0.01)) == 0) {
            List<BigDecimal> arrMoney = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                arrMoney.add(divideMoney);
            }
            return arrMoney;
        }

        Random random = new Random();
        // 金钱，按分计算 10块等于 1000分
        int money = mmm.multiply(BigDecimal.valueOf(100)).intValue();
        // 随机数总额
        double count = 0;
        // 每人获得随机点数
        double[] arrRandom = new double[number];
        // 每人获得钱数
        List<BigDecimal> arrMoney = new ArrayList<>(number);
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            BigDecimal everyMoney;
            if (i < arrRandom.length - 1) {
                everyMoney = new BigDecimal(m).divide(new BigDecimal(100));
                arrMoney.add(everyMoney);
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                everyMoney = new BigDecimal(money - c + m).divide(new BigDecimal(100));
                if (everyMoney.compareTo(BigDecimal.ZERO) <= 0) {
                    BigDecimal maxMoney = arrMoney.stream().reduce(BigDecimal::max).get();
                    if (maxMoney != null && maxMoney.compareTo(BigDecimal.valueOf(0.01)) > 0) {
                        everyMoney = BigDecimal.valueOf(0.01);
                        BigDecimal remainMoney = maxMoney.subtract(everyMoney);
                        arrMoney.remove(maxMoney);
                        arrMoney.add(remainMoney);
                    }
                }
                arrMoney.add(everyMoney);
            }
        }
        // 随机打乱每人获得金额
        Collections.shuffle(arrMoney);
        return arrMoney;
    }

    public static void main(String[] args){
        List<BigDecimal> math = math(BigDecimal.valueOf(100.12345), 5);
        math.forEach(bigDecimal -> System.out.println(bigDecimal));
    }

}
