package com.huang.study.node;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2021/4/7 10:00
 */
public class ReverseTest {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

    }

    public Node reverse(Node head) {
        Node res = null;
        while (head != null) {
            Node next = head.getNext();
            head.setNext(res);
            res = head;
            head = next;
        }
        return res;
    }



}
