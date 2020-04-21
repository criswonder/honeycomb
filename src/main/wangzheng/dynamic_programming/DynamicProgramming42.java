package dynamic_programming;

public class DynamicProgramming42 {


    static class Version1 {
        private char[] a = "mitcmu".toCharArray();
        private char[] b = "mtacnu".toCharArray();
        private int n = 6;
        private int m = 6;
        private int minDist = Integer.MAX_VALUE; // 存储结果

        public Version1(String str1, String str2) {
            a = str1.toCharArray();
            b = str2.toCharArray();
            n = a.length;
            m = b.length;
        }

        public int getMinDist() {
            return minDist;
        }

        // 调用方式 lwstBT(0, 0, 0);
        public void lwstBT(int i, int j, int edist) {
            if (i == n || j == m) {
                if (i < n) edist += (n - i);
                if (j < m) edist += (m - j);
                if (edist < minDist) minDist = edist;
                return;
            }
            if (a[i] == b[j]) { // 两个字符匹配
                lwstBT(i + 1, j + 1, edist);
            } else { // 两个字符不匹配
                lwstBT(i + 1, j, edist + 1); // 删除 a[i] 或者 b[j] 前添加一个字符
                lwstBT(i, j + 1, edist + 1); // 删除 b[j] 或者 a[i] 前添加一个字符
                lwstBT(i + 1, j + 1, edist + 1); // 将 a[i] 和 b[j] 替换为相同字符
            }
        }

        public void lwstBT2(int i, int j, int edist) {
            if (i == n || j == m) {
                if (i < n) edist += n - i;
                if (j < m) edist += m - j;

                if (edist < minDist) minDist = edist;

                return;
            }

            if (a[i] == a[j]) {
                lwstBT2(i + 1, j + 1, edist);
            } else {
                //i,j都有两种变换，要么不变要么加一，2x2总共四种组合，可以思考一下注释掉的两种

                // 1 把a[i]删除，然后看a[i+1]和b[j]是否匹配。2 在b[j]之前插入一个a[i]，然后比较a[i+1]和b[j]
                lwstBT2(i + 1, j, edist + 1);

                //lwstBT2(i + 1, j + 1, edist + 1);

                // 1 把b[j]删除，然后比较a[i]和b[j+1]。2 在a[i]前插入一个b[j]，然后比较a[i]和b[j+1]
                lwstBT2(i, j + 1, edist + 1);

                //lwstBT2(i, j, edist + 1);

                // 把a[i]和b[j]替换成为一样的
                lwstBT2(i + 1, j + 1, edist + 1);
            }
        }


    }


    public static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j])
                    //可以这么理解，当a[i] == b[j]时候，从(i-1,j-1,minDist)过来是不需要编辑距离加1的。
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    private static int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

    public static void main(String[] args) {
//        Version1 lwstTest = new Version1("maocceg", "mcoccdf");
//        lwstTest.lwstBT(0, 0, 0);
//        System.out.println(lwstTest.getMinDist());

        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();

        int lwstDP = lwstDP(a, a.length, b, b.length);
        assert lwstDP == 3;
    }

}
