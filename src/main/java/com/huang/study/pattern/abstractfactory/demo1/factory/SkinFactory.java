package com.huang.study.pattern.abstractfactory.demo1.factory;

import com.huang.study.pattern.abstractfactory.demo1.Button;
import com.huang.study.pattern.abstractfactory.demo1.ComboBox;
import com.huang.study.pattern.abstractfactory.demo1.TextField;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 14:44
 * @Description: 抽象工厂
 */
public interface SkinFactory {
    public Button createButton();
    public TextField createTextField();
    public ComboBox createComboBox();
}
