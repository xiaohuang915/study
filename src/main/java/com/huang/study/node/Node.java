package com.huang.study.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2021/4/7 9:57
 */
@Getter
@Setter
public class Node {

    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }
}
