package dynamic_programming;

import utils.PrintUtils;

import java.util.*;

public class DynamicProgramming40 {


    static class Version1 {
        public int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
        public int[] weight = {2, 2, 4, 6, 3};  // 物品重量
        public int n = 5; // 物品个数
        public int w = 9; // 背包承受的最大重量
        public boolean[][] mem = new boolean[5][10]; // 备忘录,默认值 false
        boolean[][] states;

        /**
         * 回溯算法，没有使用备忘录
         *
         * @param i
         * @param cw
         */
        public void fNoMemo(int i, int cw) {
            if (i == n || cw > w) {
                if (cw > maxW) maxW = cw;
                System.out.println(String.format("i=%d,cw=%d,maxW=%d", i, cw, maxW));
                return;
            }

            if (weight[i] + cw <= w) {
                fNoMemo(i + 1, cw + weight[i]);
            }
            fNoMemo(i + 1, cw);
        }

        public void f(int i, int cw) { // 调用 f(0, 0)
            if (cw == w || i == n) { // cw==w 表示装满了,i==n 表示物品都考察完了
                if (cw > maxW) maxW = cw;
                return;
            }
            if (mem[i][cw]) return; // 重复状态
            mem[i][cw] = true; // 记录 (i, cw) 这个状态
            f(i + 1, cw); // 选择不装第 i 个物品
            if (cw + weight[i] <= w) {
                f(i + 1, cw + weight[i]); // 选择装第 i 个物品
            }
        }

        //weight: 物品重量,n: 物品个数,w: 背包可承载重量
        public int knapsack(int[] weight, int n, int w) {
            states = new boolean[n][w + 1]; // 默认值 false

            // 第一行的数据要特殊处理,可以利用哨兵优化
            states[0][0] = true;
            states[0][weight[0]] = true;

            for (int i = 1; i < n; ++i) { // 动态规划状态转移
                for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                    if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
                }
                for (int j = 0; j <= w - weight[i]/*第i个物品还没有放入,背包里的重量最多是w-weight[i]种情况,考察j>w-weight[i]的情况没有意义,背包会装满*/; ++j) {// 把第 i 个物品放入背包
                    if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
                }
            }
            for (int i = w; i >= 0; --i) { // 输出结果
                if (states[n - 1][i] == true) return i;
            }
            return 0;
        }

        public static int knapsack2(int[] items, int n, int w) {
            boolean[] states = new boolean[w + 1]; // 默认值 false

            // 第一行的数据要特殊处理,可以利用哨兵优化
            states[0] = true;
            states[items[0]] = true;

            for (int i = 1; i < n; ++i) { // 动态规划
                for (int j = w - items[i]; j >= 0; --j) {// 把第 i 个物品放入背包 //为什么这里要从大到小循环：第i轮循环中新设置的值会干扰到后面的设值。
                    if (states[j] == true) states[j + items[i]] = true;
                }
            }
            for (int i = w; i >= 0; --i) { // 输出结果
                if (states[i] == true) return i;
            }
            return 0;
        }
    }

    static class Version2 {
        private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
        public static int[] weight = {2, 2, 4, 6, 3};  // 物品的重量
        public static int[] value = {3, 4, 8, 9, 6}; // 物品的价值
        public static int n = 5; // 物品个数
        public static int w = 9; // 背包承受的最大重量

        public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
            if (cw == w || i == n) { // cw==w 表示装满了,i==n 表示物品都考察完了
                if (cv > maxV) maxV = cv;
                return;
            }
            f(i + 1, cw, cv); // 选择不装第 i 个物品
            if (cw + weight[i] <= w) {
                f(i + 1, cw + weight[i], cv + value[i]); // 选择装第 i 个物品
            }
        }

        public static int knapsack3(int[] weight, int[] value, int n, int w) {
            int[][] states = new int[n][w + 1];
            for (int i = 0; i < n; ++i) { // 初始化 states
                for (int j = 0; j < w + 1; ++j) {
                    states[i][j] = -1;
                }
            }
            states[0][0] = 0;
            states[0][weight[0]] = value[0];
            for (int i = 1; i < n; ++i) { // 动态规划，状态转移
                for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                    if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
                }
                for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
                    if (states[i - 1][j] >= 0) {
                        int v = states[i - 1][j] + value[i];
                        if (v > states[i][j + weight[i]]) {
                            states[i][j + weight[i]] = v;
                        }
                    }
                }
            }
            // 找出最大值
            int maxvalue = -1;
            for (int j = 0; j <= w; ++j) {
                if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
            }
            return maxvalue;
        }


        public static int knapsack4(int[] weight, int[] value, int n, int w) {
            int[] states = new int[w + 1];
            for (int i = 0; i < w + 1; ++i) { // 初始化 states
                states[i] = -1;
            }
            states[0] = 0;
            states[weight[0]] = value[0];
            for (int i = 1; i < n; ++i) { // 动态规划，状态转移
                //不装

                //装
//                for (int j = 0; j <= w - weight[i]; j++) {
                for (int j = w - weight[i]; j >= 0; j--) {
                    if (states[j] >= 0) {
                        int tempWeight = j + weight[i];
                        int tempValue = states[j] + value[i];
                        if (tempValue > states[tempWeight]) {
                            states[tempWeight] = tempValue;
                        }
                    }
                }
            }
            // 找出最大值
            int maxvalue = -1;
            for (int j = 0; j <= w; ++j) {
                if (states[j] > maxvalue) maxvalue = states[j];
            }
            return maxvalue;
        }

        // items 商品价格，n 商品个数, w 表示满减条件，比如 200
        public static void double11advance(int[] items, int n, int w) {
            boolean[][] states = new boolean[n][3 * w + 1];// 超过 3 倍就没有薅羊毛的价值了
            states[0][0] = true;  // 第一行的数据要特殊处理
            states[0][items[0]] = true;
            for (int i = 1; i < n; ++i) { // 动态规划
                for (int j = 0; j <= 3 * w; ++j) {// 不购买第 i 个商品
                    if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
                }
                for (int j = 0; j <= 3 * w - items[i]; ++j) {// 购买第 i 个商品
                    if (states[i - 1][j] == true) states[i][j + items[i]] = true;
                }
            }

            int j;
            for (j = w; j < 3 * w + 1; ++j) {
                if (states[n - 1][j] == true) break; // 输出结果大于等于 w 的最小值
            }
            if (j == 3 * w + 1) return; // 没有可行解
            for (int i = n - 1; i >= 1; --i) { // i 表示二维数组中的行，j 表示列
                if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                    System.out.print(items[i] + " "); // 购买这个商品
                    j = j - items[i];
                } // else 没有购买这个商品，j 不变。
            }
            if (j != 0) System.out.print(items[0]);
        }


    }


    public static void main(String[] args) {
        //测试回溯算法，没有使用备忘录的
//        Version1 noMemo = new Version1();
//        noMemo.fNoMemo(0, 0);
//        System.out.println("result = " + noMemo.maxW);

        printSelectedItems();

        //打印出选择了哪些数字
//        Version1 version1 = new Version1();
//        version1.f(0, 0);
//        System.out.println(version1.maxW);
//        PrintUtils.printMatrix(version1.mem);

        //test version1
//        Version1 nest = new Version1();
//        int maxWeight = nest.knapsack(nest.weight, nest.n, nest.w);
//        System.out.println("maxWeight=" + maxWeight);
//        maxWeight = nest.knapsack(new int[]{2, 5, 7, 2}, 4, 10);
//        System.out.println("maxWeight=" + maxWeight);
//
        //test version2
//        int[] items = new int[]{2, 3, 4, 8, 10, 8, 8};
//        Version2 version2 = new Version2();
//        version2.double11advance(items, items.length, 19);

//        int[] weight = {2, 2, 4, 6, 3};  // 物品的重量
//        int[] value = {3, 4, 8, 9, 6}; // 物品的价值
//        int n = 5; // 物品个数
//        int w = 9; // 背包承受的最大重量
//        int resultValue = Version2.knapsack3(weight, value, n, w);
//        System.out.println("resultValue="+resultValue);


//        int[] weight = {2, 2, 2, 2, 2};  // 物品的重量
//        int[] value = {3, 4, 8, 9, 10}; // 物品的价值
//        int n = 5; // 物品个数
//        int w = 9; // 背包承受的最大重量
//        int resultValue = Version2.knapsack3(weight, value, n, w);
//        System.out.println("resultValue=" + resultValue);
//
//        resultValue = Version2.knapsack4(weight, value, n, w);
//        System.out.println("resultValue=" + resultValue);

    }

    /**
     * 打印出满足条件的情况时选择了哪些数字
     */
    private static void printSelectedItems() {
        Version1 data = new Version1();
//        int[] a = {4, 3, 5, 8, 9, 3, 44, 3, 9};
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int maxWeight = 32;
        int n = a.length;
        int knapsack = data.knapsack(a, n, maxWeight);
        System.out.println("result = " + knapsack);
        boolean[][] states = data.states;
//        PrintUtils.printMatrix(states);

        //找到最大的总重量的坐标, resultI是行index, resultJ是列index
        int resultI = 0, resultJ = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean find = false;
            for (int j = maxWeight; j > 0; j--) {
                if (states[i][j]) {
                    resultI = i;
                    resultJ = j;
                    find = true;
                    break;
                }
            }
            if (find) break;
        }

        //循环找出选择了哪些数字
        LinkedList<Integer> resultList = new LinkedList<>();
        int tmpI = resultI, tmpJ = resultJ;
        while (tmpI > 0) {
            if (states[tmpI - 1][resultJ]) {
                //没有选择a[i]
            } else {
                int cWeight = tmpJ - a[tmpI];
                if (cWeight >= 0 && states[tmpI - 1][cWeight]) {
                    resultList.add(resultList.size(), a[tmpI]);
                    tmpJ = cWeight;
                }
            }
            tmpI--;
        }
        if (tmpJ > 0) {
            resultList.add(resultList.size(), a[tmpI]);
        }

        //打印出选择了哪些数字
        Iterator<Integer> listIterator = resultList.descendingIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

}
