package sorts_12;

import utils.PrintUtils;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] testArray = {33, 31, 40, 90, 22, 9, 33, 88, 68, 81};

        mergeSort(testArray, testArray.length);

        PrintUtils.printArray(testArray);

        int[] testArray2 = {33, 31, 40, 90, 22, 9, 33, 88, 68, 81};
        mergeSortAndy(testArray2, 0, testArray2.length - 1);
        PrintUtils.printArray(testArray2);
    }


    private static void mergeSortAndy(int[] a, int p, int r) {
        if (p >= r) return;
        int q = p + ((r - p) >> 1);
        mergeSortAndy(a, p, q);
        mergeSortAndy(a, q + 1, r);
        mergeAndy(a, p, q, r);
    }

    private static void mergeAndy(int[] a, int p, int q, int r) {
        int tmp[] = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        if (i <= q) tmp[k++] = a[i++];
        if (j <= r) tmp[k++] = a[j++];
        for (int l = 0; l < tmp.length; l++) {
            a[p + l] = tmp[l];
        }
    }


    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * p=0,q=0,r=1
     * <p>
     * i = 0,
     * j = 1
     * k=0
     * <p>
     * int[] tmp = new int[2]
     * <p>
     * start = i = 0
     * end = q = 0
     * <p>
     * tmp[1] = a[0] start++
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

}
