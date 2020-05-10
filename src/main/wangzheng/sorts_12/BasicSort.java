package sorts_12;

import utils.MiscUtils;
import utils.PrintUtils;

public class BasicSort {
    public static void main(String[] args) {
//        int[] testArray = {33, 31, 40, 90, 22, 9, 33, 88, 68, 81};
//        int[] testArray = {90, 88, 81, 68, 40, 33, 33, 31, 22, 9, 22};
        int[] testArray = {1, 2, 4, 5, 8, 3};


//        utils.PrintUtils.printArray(testArray);
//        andyInsertSort(testArray, testArray.length);
//        insertionSort(testArray, testArray.length);
        bubbleSort2(testArray, testArray.length);
//        insertSort2(testArray);
//        insertSort3(testArray);
//        bubbleSort2(testArray, testArray.length);
        PrintUtils.printArray(testArray);
//        int[] testArray2 = {33, 31, 40, 90, 22, 9, 33, 88, 68, 81};
//        utils.PrintUtils.printArray(testArray2);
    }

    /**
     * {33, 31, 40, 90, 22, 9, 33, 88, 68, 81};
     * 思考一：{31,33,40,22,9,33,88,68,81,90} 这样一种情况，数组本来就是有序的，思考一下插入的过程，时间复杂度就是O(n)
     * 思考二：{1, 2, 3, [1], 22, 9, 33, 88, 68, 81}; 1插入的过程
     *
     * @param a
     * @param n
     */
    public static void andyInsertSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int toInsert = a[i + 1];
            int j = i;
            while (j >= 0) {
                if (a[j] > toInsert) {
                    MiscUtils.swap(a, j, j + 1);
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = toInsert;
        }
    }

    public static void bubbleSort2(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            boolean hasSwitch = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    MiscUtils.swap(a, j, j + 1);
                    hasSwitch = true;
                }
            }
            if (!hasSwitch) {
                break;
            }
        }
    }

    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int destIndex = n - 1 - i;
            int maxIndex = 0;
            for (int j = 0; j <= n - 1 - i; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tmp = a[destIndex];
            a[destIndex] = a[maxIndex];
            a[maxIndex] = tmp;
        }
    }

    /**
     * 1 每循环一次，操作的数据长度减一
     * 2 没有数据交换后，退出循环，真个数据有序了
     *
     * @param a
     * @param n
     */
    public static void bubbleSortAndy(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        //这里i小于n-1 或者n，关系不大。当小于n的时候，i等于n-1的时候。第二层for循环的判断条件是j<n-(n-1)-1
        //也就是j<0, for循环不会执行
        for (int i = 0; i < n - 1; i++) {
            boolean hasElementSwitch = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
//                    int tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;

                    //位的异或运算可以参考
                    //a     [0,1,1,0,1]
                    //b     [1,0,1,0,1]
                    //a^b   [1,1,0,0,0]
                    //a^b^b [0,1,1,0,1]

//                    a[j] = a[j + 1] ^ a[j];
//                    a[j + 1] = a[j] ^ a[j + 1];
//                    a[j] = a[j] ^ a[j + 1];


                    a[j] = a[j] * a[j + 1];
                    a[j + 1] = a[j] / a[j + 1];
                    a[j] = a[j] / a[j + 1];

                    hasElementSwitch = true;
                }
            }

            if (!hasElementSwitch) {
                System.out.println("i=" + i);
                break;
            }
        }
    }

    // 冒泡排序，a 表示数组，n 表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }


    // 插入排序，a 表示数组，n 表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

}
