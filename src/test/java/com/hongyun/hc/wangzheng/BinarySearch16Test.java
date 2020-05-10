package com.hongyun.hc.wangzheng;

import binarysearch.BinarySearch16;
import org.junit.Test;

public class BinarySearch16Test {
    //变体四：查找最后一个小于等于给定值的元素。
    // eg:2,3,4,7中最后一个小于等于5的应该是4
    // eg:2,3,4,7中最后一个小于等于8的应该是7
    // eg:2,3,4,4,7中最后一个小于等于4的应该是第二个4
    @Test
    public void test4() {
        int index = -1;
        BinarySearch16 binarySearch16 = new BinarySearch16();
        int[] test1 = new int[]{2, 3, 4, 7};
        index = binarySearch16.bsearch4(test1, test1.length, 5);
        assert index == 2;

        test1 = new int[]{2, 3, 4, 7};
        index = binarySearch16.bsearch4(test1, test1.length, 8);
        assert index == 3;

        test1 = new int[]{2, 3, 4, 4, 7};
        index = binarySearch16.bsearch4(test1, test1.length, 4);
        assert index == 3;
    }

    //变体三：查找第一个大于等于给定值的元素。
    // eg:2, 3, 8, 9, 10中第一个大于等于3的元素，下标是1
    // eg:2, 3, 8, 9, 10中第一个大于等于7的元素，下标是2
    // eg:2, 3, 8, 9, 10中第一个大于等于11的元素，下标是-1
    @Test
    public void test3() {
        int[] a = new int[]{2, 3, 8, 9, 10};
        BinarySearch16 runner = new BinarySearch16();
        assert 1 == runner.bsearch3(a, a.length, 3);
        assert 2 == runner.bsearch3(a, a.length, 7);
        assert -1 == runner.bsearch3(a, a.length, 11);
    }

    //变体二：查找最后一个值等于给定值的元素
    @Test
    public void test2() {
        int[] a = new int[]{2, 3, 8, 8, 9, 10};
        BinarySearch16 runner = new BinarySearch16();
        assert 3 == runner.bsearch2(a, a.length, 8);
    }

    //变体一：查找第一个值等于给定值的元素
    @Test
    public void test1() {
        int[] a = new int[]{2, 3, 8, 8, 9, 10};
        BinarySearch16 runner = new BinarySearch16();
        assert 2 == runner.bsearch1(a, a.length, 8);
    }

    //变体一：普通二分查找
    @Test
    public void test() {
        BinarySearch16 binarySearch16 = new BinarySearch16();
        int[] test1 = {1, 2, 3, 3, 3, 4, 5, 6};

        int index = binarySearch16.bsearch(test1, test1.length, 15);
        assert index == -1;
        index = binarySearch16.bsearch(test1, test1.length, 5);
        assert index == 6;
    }
}
