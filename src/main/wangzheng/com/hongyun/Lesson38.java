package com.hongyun;

public class Lesson38 {

    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q - i + 1); // 统计p-q之间，比a[j]大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= r) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r - p; ++i) { // 从tmp拷贝回a
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Lesson38 lesson38 = new Lesson38();
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int count = lesson38.count(a, a.length);
        System.out.println("count=" + count);

//        int[] a = {3, 2, 1, 7, 9, 2, 2};
//        int count = lesson38.count(a, a.length);
//        System.out.println("count=" + count);
    }
}
