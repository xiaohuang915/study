package com.huang.study.pattern.abstractfactory.demo1.factory;

import com.huang.study.pattern.abstractfactory.demo1.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 14:48
 * @Description:
 */
public class SummerSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
