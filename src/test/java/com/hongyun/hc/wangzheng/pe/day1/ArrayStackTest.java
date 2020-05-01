package com.hongyun.hc.wangzheng.pe.day1;

import org.junit.Test;
import pe.day1.ArrayStack;

import java.util.ArrayList;

public class ArrayStackTest {

    @Test
    public void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>(2);
        stack.push(1);
        System.out.println("size="+stack.size());

        stack.push(2);
        System.out.println("size="+stack.size());

        stack.push(3);
        System.out.println("size="+stack.size());

        stack.push(4);
        System.out.println("size="+stack.size());

        while (!stack.isEmpty()) {
            System.out.println("pop "+stack.pop());
        }

//        assert stack.pop() == 4;
//        assert stack.pop() == 3;
//        assert stack.pop() == 2;
//        assert stack.pop() == 1;
    }
}
