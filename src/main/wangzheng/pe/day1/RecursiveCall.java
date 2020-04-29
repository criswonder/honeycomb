package pe.day1;

import utils.PrintUtils;

import java.util.Arrays;

public class RecursiveCall {
    public static void main(String[] args) {
//        int[] test = {1, 2, 3};
//
//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        int[] array = {1, 2, 3};
//        allSort(array, 0, array.length - 1);
//        PrintUtils.printArray(array);
//
////        printShabang(9);
//        System.out.println("\n" + calculateShabang(5));

        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i + 1));
        }
    }

    //permutation
    static void allSort(int[] array, int begin, int end) {
        if (begin == end) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end);
            swap(array, begin, i);
        }
    }

    static void swap(int[] array, int a, int b) {
        System.out.println(String.format("arr[%d]=%d,arr[%d]=%d", a, array[a], b, array[b]));
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    static void printShabang(int i) {
        if (i >= 1) {
            System.out.print(i + (i == 1 ? "" : "*"));
            printShabang(i - 1);
        }
    }

    static int calculateShabang(int i) {
        if (i >= 1) {
            System.out.print(i + (i == 1 ? "" : "*"));
            return i * calculateShabang(i - 1);
        }
        return 1;
    }

    //斐波那契数列（Fibonacci sequence）
    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
