package sorts_12;

import org.junit.Assert;
import utils.MiscUtils;
import utils.PrintUtils;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] testArray = new int[]{6, 11, 3, 19, 8, 2, 9, 4, 10, 5, 7};
//        QuickSort.quickSort(testArray, testArray.length);
        QuickSort.andyQuickSort(testArray, 0, testArray.length - 1);
        PrintUtils.printArray(testArray);
//        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 19},
//                testArray);

//        System.out.println("kTH=" + findKth(testArray, 1));
//        System.out.println("kTH=" + findKth(testArray, 2));
//        System.out.println("kTH=" + findKth(testArray, 3));
//        System.out.println("kTH=" + findKth(testArray, 4));
//        System.out.println("kTH=" + findKth(testArray, 5));
    }

    public static int findKth(int[] a, int k) {
        int pivot = partitionAndy(a, 0, a.length - 1);
        int i = 0, j = a.length - 1;
        while (pivot != (a.length - k)) {
            if (pivot > (a.length - k)) {
                j = pivot - 1;
            } else {
                i = pivot + 1;
            }
            pivot = partitionAndy(a, i, j);
        }
        return a[pivot];
    }

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

//        System.out.println("i=" + i);
        return i;
    }

    public static void andyQuickSort(int[] a, int p, int r) {
        if (p >= r) return;
        int pivot = partitionAndy(a, p, r);
        andyQuickSort(a, p, pivot - 1);
        andyQuickSort(a, pivot + 1, r);
    }

    private static int partitionAndy(int[] a, int p, int r) {
        int i = p, j = p;
        int value = a[r];
        while (j < r) {
            if (a[j] <= value) {
                if (i != j) {
                    MiscUtils.swap(a, j, i);
                }
                i++;
            }
            j++;
        }

        MiscUtils.swap(a, r, i);
        return i;
    }
}