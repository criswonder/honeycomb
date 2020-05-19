package com.hongyun.pe.bytedance;

import org.junit.Test;


//整型无序数组a，第i下标的值为a[i]，找任意一对下标（i，j)使得i<j 且a[i] < a[j]
public class Practice2 {
    @Test
    public void testOperatorPriority() {
        int c = 2 + (4 - 2) >> 1;
        System.out.println(c);

        c = (2 + (4 - 2)) >> 1;
        System.out.println(c);

        c = 2 + ((4 - 2) >> 1);
        System.out.println(c);
    }

    @Test
    public void tc1() {
        int[] a = new int[]{9, 1, 100, 88, 33, 22, 101, 10};
        assert findJ(a, 2) == 6;
    }


    public int findJ(int[] a, int i) {
        if (a == null || a.length == 0 || i >= a.length - 2) return -1;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] > a[i]) return j;
        }
        return -1;
    }

    @Test
    public void tc2() {
        int[] a = new int[]{9, 1, 100, 88, 33, 22, 101, 10};
        findPair(a, 0, a.length - 1);
        System.out.println("find=" + find + ",r1=" + r1 + ",r2=" + r2);
    }

    @Test
    public void tc3() {
        int[] a = new int[]{9, 1, 100};
        findPair(a, 0, a.length - 1);
        System.out.println("find=" + find + ",r1=" + r1 + ",r2=" + r2);
    }

    @Test
    public void tc4() {
        int[] a = new int[]{9, 11, 100, 22};
        findPair(a, 0, a.length - 1);
        System.out.println("find=" + find + ",r1=" + r1 + ",r2=" + r2);
    }

    @Test
    public void tc5() {
        int[] a = new int[]{6, 5, 4};
        findPair(a, 0, a.length - 1);
        System.out.println("find=" + find + ",r1=" + r1 + ",r2=" + r2);
    }

    @Test
    public void tc6() {
        int[] a = new int[]{6, 5, 4, 3, 5, 3, 2, 2, 2,};
        findPair(a, 0, a.length - 1);
        assert find && r1 == 2 && r2 == 4;
        System.out.println("find=" + find + ",r1=" + r1 + ",r2=" + r2);
    }

    int r1, r2;
    boolean find;

    public int[] findPair(int[] a, int p, int q) {
        System.out.println("p=" + p + ",q=" + q);
        if (find) return null;
        if (p >= q) return null;
        int mid = p + ((q - p) >> 1);
        findPair(a, p, mid);
        findPair(a, mid + 1, q);
        doFindPair(a, p, mid, q);
        return null;
    }

    private void doFindPair(int[] a, int p, int mid, int q) {
        for (int i = p; i <= mid; i++) {
            for (int j = mid + 1; j <= q; j++) {
                if (a[i] < a[j]) {
                    r1 = i;
                    r2 = j;
                    find = true;
                    return;
                }
            }
        }
    }
}
