package com.huang.study.hutool;

import java.util.Stack;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/29 13:55
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) //先行判断剔除
            return false;
        Stack<Character> stack = new Stack<>(); //创建 stack 对象
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')    // 入栈
                stack.push(c);
            else {
                if (stack.isEmpty())     //针对首先出现的右侧符号进行判断
                    return false;

                char top = stack.pop();     // 出栈

                if (c == ')' && top != '(') //对应匹配
                    return false;
                if (c == ']' && top != '[')
                    return false;
                if (c == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty(); //检查栈是否为空
    }
}
