package pe.day1;

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

//        for (int i = 0; i < 10; i++) {
//            System.out.println(fibonacci(i + 1));
//        }
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

    private static void swap(int[] array, int a, int b) {
        System.out.println(String.format("arr[%d]=%d,arr[%d]=%d", a, array[a], b, array[b]));
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    static void printFactorial(int i) {
        if (i >= 1) {
            System.out.print(i + (i == 1 ? "" : "*"));
            printFactorial(i - 1);
        }
    }

    //求阶乘
    static int calculateFactorial(int i) {
        if (i >= 1) {
            System.out.print(i + (i == 1 ? "" : "*"));
            return i * calculateFactorial(i - 1);
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

    public static int sqrt2(int s) {
        int x = s/9;
        if (x == 0) return 0;
        return (int) sqrts(x, s);
    }

    private static double sqrts(double x, int s) {
        //假设res这一步将等于x。下列的等式就是：x = (x+s/x)/2 ==> 2x = x+ s/x ==>x^2 = s;
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res, s);
        }
    }

    //开平方根（square root）
    public static int sqrt(int x) {
        if (x == 1) {
            return x;
        }
        int start = 0;
        int end = x / 2;

        if (end * end == x) {
            return end;
        }

        int lastStart = -1, lastEnd = -1;
        while (start < end) {
            if (lastEnd == end && lastStart == start) {
                break;
            }

            if (lastEnd != end) {
                lastEnd = end;
            }

            if (lastStart != start) {
                lastStart = start;
            }

            int i = start + (end - start) / 2;
            int squre = i * i;
            if (squre == x) {
                return i;
            } else if (squre < x) {
                start = i + 1;
            } else {
                end = i - 1;
            }
        }

        if (start * start > x) {
            return start - 1;
        } else if (start * start < x && ((start + 1) * (start + 1) <= x)) {
            return start + 1;
        }
        return start;
    }
}
