package com.hongyun.hc.wangzheng;

import linkedlist.LinkedList07;
import org.junit.Test;

import static linkedlist.LinkedList07.createList;
import static linkedlist.LinkedList07.printAll;

public class LinkedList07Test {

    @Test
    public void deleteLinkedListKthNode() {
        LinkedList07.Node list = createList();
        int k = 3;
        System.out.println(String.format("删除倒数第%d个节点：", k));
        printAll(list);
        LinkedList07.Node node = LinkedList07.deleteLastKthAndy(list, k);
        System.out.println(String.format("删除后："));
        printAll(node);
    }

    @Test
    public void deleteLinkedListKthNode2() {
        LinkedList07.Node list = createList();
        int k = 8;
        System.out.println(String.format("删除倒数第%d个节点：", k));
        printAll(list);
        LinkedList07.Node node = LinkedList07.deleteLastKthAndy(list, k);
        System.out.println(String.format("删除后："));
        printAll(node);
    }

    @Test
    public void deleteLinkedListKthNode3() {
        LinkedList07.Node list = createList();
        int k = 1;
        System.out.println(String.format("删除倒数第%d个节点：", k));
        printAll(list);
        LinkedList07.Node node = LinkedList07.deleteLastKthAndy(list, k);
        System.out.println(String.format("删除后："));
        printAll(node);
    }
}
