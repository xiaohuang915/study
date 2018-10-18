package com.huang.study.pattern.abstractfactory.demo1;

import com.huang.study.pattern.abstractfactory.demo1.factory.SkinFactory;
import com.huang.study.pattern.abstractfactory.demo1.factory.SummerSkinFactory;

/**
 * @Auther: pc.huang
 * @Date: 2018/7/27 15:17
 * @Description:
 */
public class Test {
    public static void main(String[] args){
        SkinFactory skinFactory = new SummerSkinFactory();
        Button button = skinFactory.createButton();
        ComboBox comboBox = skinFactory.createComboBox();
        TextField textField = skinFactory.createTextField();
        button.display();
        comboBox.display();
        textField.display();
    }
}
