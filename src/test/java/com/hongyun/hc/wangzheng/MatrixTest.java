package com.hongyun.hc.wangzheng;

import org.junit.Test;

public class MatrixTest {

    @Test
    public void testPrintMatrixClockWise() {
        int[][] matrix = {
                {1, 2, 3, -1, -2},
                {4, 5, 6, -1, -2},
                {7, 8, 9, -1, -2},
                {10, 11, 12, -1, -2},
                {-4, -4, -4, -4, -4},
        };
        printMatrixClockWise(matrix, 0, matrix[0].length, 0, matrix.length);

//        printMatrixClockWise(matrix, 1, 3, 1, 3);
    }

    //顺时针打印一个矩阵
    private void printMatrixClockWise(int[][] a, int cStart, int cEnd, int rStart, int rEnd) {
        if (cStart >= cEnd || rStart >= rEnd) return;
        //打印行
        for (int i = cStart; i < cEnd; i++) {
            System.out.println(a[rStart][i]);
        }

        //打印最后一列
        for (int i = rStart + 1; i < rEnd; i++) {
            System.out.println(a[i][cEnd - 1]);
        }

        //从右到左打印最后一行
        for (int i = cEnd - 2; i >= cStart; i--) {
            System.out.println(a[rEnd - 1][i]);
        }

        if (rStart + 1 < rEnd - 1) {
            //从下到上打印第一列
            for (int i = rEnd - 2; i > rStart; i--) {
                System.out.println(a[i][cStart]);
            }
        }

        cStart++;
        cEnd--;
        rStart++;
        rEnd--;
        System.out.println("==================");
        if (cStart < cEnd && rStart < rEnd) printMatrixClockWise(a, cStart, cEnd,
                rStart, rEnd);
    }
}
