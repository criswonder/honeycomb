package backtracking_39;

public class BackTrackingMain {
    static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    //i 表示考察到哪个物品了；
    //cw 表示当前已经装进去的物品的重量和；
    //items 表示每个物品的重量；
    //n 表示物品个数。总的物品个数
    // w 背包重量；
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            System.out.println("cw=" + cw + ",i=" + i + ",maxW=" + maxW);
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
//            System.out.println(i + ":" + items[i]);
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
//        int[] items = {8, 9, 33, 2, 11, 33, 23, 12, 9, 5, 6, 7, 3, 4};
//        f(0, 0, items, items.length, 20);

//        BackTrackingMain backTrackingMain = new BackTrackingMain();
//        backTrackingMain.cal8queens(0);

        Test8Queens test8Queens = new Test8Queens();
//        test8Queens.queens[0] = 3;
//        test8Queens.queens[1] = 3;
//        test8Queens.printQueens();

        test8Queens.calc(0);
//        test8Queens.printQueens();
    }

    static class Test8Queens {
        int[] queens = new int[8];

        public void calc(int row) {
            if (row == 8) {
                printQueens();
                return;
            }

            boolean findPosition = false;
            for (int column = 0; column < 8; column++) {
                if (isOk(row, column)) {
                    findPosition = true;
                    queens[row] = column;
                    calc(row + 1);
                }
            }

            //会存在一行找不到放置的地方。直接会返回。打印的列表会使用别的循环的值。
            //所以看到后面的行还有Q
            if (!findPosition) {
                System.out.println(row+" is bad");
                printQueens();
            }
        }

        public boolean isOk(int row, int column) {
            int leftUp = column - 1;
            int rightUp = column + 1;
            while (row >= 1) {
                if (queens[row - 1] == column) {
                    return false;
                }
                if (queens[row - 1] == leftUp) {
                    return false;
                }
                if (queens[row - 1] == rightUp) {
                    return false;
                }
                leftUp--;
                rightUp++;
                row--;
            }
            return true;
        }

        public void printQueens() {
            for (int i = 0; i < queens.length; i++) {
                for (int j = 0; j < queens.length; j++) {
                    if (queens[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列

    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
