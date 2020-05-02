package com.hongyun.hc.wangzheng;

import org.junit.Assert;
import org.junit.Test;
import sorts_12.BasicSort;

import java.util.Arrays;

public class BasicSortTest {

    @Test
    public void inertTest() {
        int[] arr = new int[]{5, 8, 9, 10, 3, 11};
        int[] copy = Arrays.copyOf(arr, arr.length);

        BasicSort.andyInsertSort(arr, arr.length);
        Arrays.sort(copy);

        Assert.assertArrayEquals(arr, copy);

        int[] arr2 = new int[]{1};
        BasicSort.andyInsertSort(arr2, 1);
    }

    @Test
    public void bubbleSort2Test() {
        int[] arr = new int[]{5, 8, 9, 10, 3, 11};
        int[] copy = Arrays.copyOf(arr, arr.length);

        BasicSort.bubbleSort2(arr, arr.length);
        Arrays.sort(copy);

        Assert.assertArrayEquals(arr, copy);
    }

    @Test
    public void selectionSort2Test() {
        int[] arr = new int[]{5, 8, 9, 10, 3, 11};
        int[] copy = Arrays.copyOf(arr, arr.length);

        BasicSort.selectionSort(arr, arr.length);
        Arrays.sort(copy);

        Assert.assertArrayEquals(arr, copy);
    }
}
