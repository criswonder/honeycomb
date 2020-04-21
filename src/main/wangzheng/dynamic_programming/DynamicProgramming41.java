package dynamic_programming;

public class DynamicProgramming41 {


    static class Version1 {
        private int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量

        // 调用方式：minDistBacktracing(0, 0, 0, w, n);
        public void minDistBT(int i, int j, int dist, int[][] w, int n) {
            // 到达了 n-1, n-1 这个位置了，这里看着有点奇怪哈，你自己举个例子看下
            if (i == n - 1 && j == n - 1) {
                dist = dist + w[i][j];
                if (dist < minDist) minDist = dist;
                return;
            }
            if (i < n - 1) { // 往下走，更新 i=i+1, j=j
                System.out.println("1: i=" + i + ",j=" + j);
                minDistBT(i + 1, j, dist + w[i][j], w, n);
            }
            if (j < n - 1) { // 往右走，更新 i=i, j=j+1
                System.out.println("2: i=" + i + ",j=" + j);
                minDistBT(i, j + 1, dist + w[i][j], w, n);
            }
        }

        public int minDistDP(int[][] matrix, int n) {
            int[][] states = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; ++j) { // 初始化 states 的第一行数据
                sum += matrix[0][j];
                states[0][j] = sum;
            }
            sum = 0;
            for (int i = 0; i < n; ++i) { // 初始化 states 的第一列数据
                sum += matrix[i][0];
                states[i][0] = sum;
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < n; ++j) {
                    states[i][j] =
                            matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
                }
            }
            return states[n - 1][n - 1];
        }

        private int[][] mem = new int[4][4];

        public int minDist(int i, int j, int[][] matrix) { // 调用 minDist(n-1, n-1);
            if (i == 0 && j == 0) return matrix[0][0];
            if (mem[i][j] > 0) return mem[i][j];
            int minLeft = Integer.MAX_VALUE;
            if (j - 1 >= 0) {
                minLeft = minDist(i, j - 1, matrix);
            }
            int minUp = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                minUp = minDist(i - 1, j, matrix);
            }

            int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
            mem[i][j] = currMinDist;
            return currMinDist;
        }


    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 9},
                new int[]{2, 1, 3, 4},
                new int[]{5, 2, 6, 7},
                new int[]{6, 8, 4, 3}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        Version1 version1 = new Version1();
        version1.minDistBT(0, 0, 0, matrix, 4);
        System.out.println("minDist=" + version1.minDist);

        int result = version1.minDist(3, 3, matrix);
        System.out.println("minDist=" + result);

//        int minDistDP = version1.minDistDP(matrix, 4);
//        System.out.println("minDistDP="+minDistDP);
    }

}
