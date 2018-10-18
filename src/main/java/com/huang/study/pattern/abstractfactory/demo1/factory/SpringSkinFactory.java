package com.huang.study.pattern.abstractfactory.demo1.factory;

import com.huang.study.pattern.abstractfactory.demo1.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 14:47
 * @Description:
 */
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
