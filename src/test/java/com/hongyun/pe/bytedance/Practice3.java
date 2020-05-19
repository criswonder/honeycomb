package com.hongyun.pe.bytedance;

import org.junit.Test;

import java.util.Arrays;

public class Practice3 {

    @Test
    public void tc1() {
        int[] a = new int[]{9, 1, 100, 88, 33, 22, 101, 10};
        int result = a[findJ(a)];
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        assert a[a.length / 2] == result;

        System.out.println(a[a.length / 2]);
        System.out.println(result);
    }

    @Test
    public void tc2() {
        int[] a = new int[]{4, 3, 2, 1};
        int result = a[findJ(a)];
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int index = a.length % 2 == 0 ? a.length / 2 - 1 : a.length / 2;
        assert a[index] == result;

        System.out.println(a[index]);
        System.out.println(result);
    }

    //0,1,2    3/2=1
    //0,1,2,3  4/2 = 2;
    //查找无序数组的中位数
    public int findJ(int[] a) {
        int mid = a.length % 2 == 0 ? a.length / 2 - 1 : a.length / 2;
//        int mid = a.length / 2;
        int pivot = partition(a, 0, a.length - 1);
        while (pivot != mid) {
            if (pivot < mid) {
                pivot = partition(a, pivot + 1, a.length - 1);
            } else {
                pivot = partition(a, 0, pivot - 1);
            }
        }
        return mid;
    }

    private int partition(int[] a, int p, int q) {
        int i = p, j = p;
        int pivot = a[q];

        for (; j < q; j++) {
            if (a[j] < pivot) {
                if (i == j) {

                } else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                i++;
            }
        }

        int tmp = a[i];
        a[i] = pivot;
        a[q] = tmp;

        return i;
    }
}
