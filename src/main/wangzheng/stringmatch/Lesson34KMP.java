package stringmatch;

public class Lesson34KMP {

    public static void main(String[] args) {
        String mainStr = "ababaeabac";
        String modelStr = "ababacd";
        int kmp = kmp(mainStr.toCharArray(), mainStr.toCharArray().length, modelStr.toCharArray(),
                modelStr.toCharArray().length);
        System.out.println("kmp=" + kmp);
    }

    // b表示模式串，m表示模式串的长度
    // 数组的下标是每个前缀结尾字符下标，数组的值是这个前缀的最长可以匹配前缀子串的结尾字符下标。
    // next[0] = -1
    // next[1] = -1 || 0
    // b = {a, b, a, b, a, c, d}
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        // i = 1, k = -1
        // b[0] != b[1],
        // next[1] = -1
        //
        // i = 2, k = -1
        // b[0] == b[2], ++k, k = 0;
        // next[2] = 0
        //
        // i = 3, k = 0
        // b[1] == b[3], ++k, k=1
        // next[3] = 1
        //
        // i = 4, k = 1
        // b[2] == b[4], ++k, k=2
        // next[4] = 2
        //
        // i = 5, k = 2
        // b[3] != b[5], k = next[2], k = 0; b[1] != b[5], k = next[0], k = -1
        // next[5] = -1

        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    // a, b分别是主串和模式串；n, m分别是主串和模式串的长度。
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }
}
