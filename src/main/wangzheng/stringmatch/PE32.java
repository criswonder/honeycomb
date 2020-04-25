package stringmatch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 我们今天讲的都是一维字符串的匹配方法，实际上，这两种算法都可以类比到二维空间。
 * 假设有下面这样一个二维字符串矩阵（图中的主串），借助今天讲的处理思路，如何在
 * 其中查找另一个二维字符串矩阵（图中的模式串）呢
 */
public class PE32 {
    public static void main(String[] args) {
        char[][] main = {
                {'d', 'a', 'b', 'c'},
                {'e', 'f', 'a', 'd'},
                {'c', 'c', 'a', 'f'},
                {'d', 'e', 'f', 'c'}};

        char[][] toFind = {
                {'c', 'a'},
                {'e', 'f'}};

        int[] matrix = findMatrix(main, toFind);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(" " + matrix[i]);
        }

        DataBean dataBean = findMatrix2(main, toFind);
        System.out.println(String.format("dataBean=(%d,%d)", dataBean.i, dataBean.j));
    }

    public static class DataBean {
        public final int i, j;
        public final String str;

        public DataBean(int i, int j, String str) {
            this.i = i;
            this.j = j;
            this.str = str;
        }
    }

    public static DataBean findMatrix2(char[][] main, char[][] toFind) {
        HashMap<String, DataBean> beanHashMap = new HashMap<>();
        int i = main.length - toFind.length;
        int j = main[0].length - toFind[0].length;
        StringBuilder stringBuilder;
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                stringBuilder = new StringBuilder(toFind.length + toFind[0].length);
                for (int m = 0; m < toFind.length; m++) {
                    for (int n = 0; n < toFind[0].length; n++) {
                        stringBuilder.append(main[k + m][l + n]);
                    }
                }
                beanHashMap.put(stringBuilder.toString(), new DataBean(k, l, stringBuilder.toString()));
            }
        }

        stringBuilder = new StringBuilder(toFind.length + toFind[0].length);
        for (int m = 0; m < toFind.length; m++) {
            for (int n = 0; n < toFind[0].length; n++) {
                stringBuilder.append(toFind[m][n]);
            }
        }


        return beanHashMap.get(stringBuilder.toString());
    }

    public static int[] findMatrix(char[][] main, char[][] toFind) {
        int[] result = new int[]{-1, -1};
        if (main.length < toFind.length || main[0].length < toFind[0].length) {
            return result;
        }

        int i = main.length - toFind.length;
        int j = main[0].length - toFind[0].length;
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                boolean isMatch = true;
                for (int m = 0; m < toFind.length; m++) {
                    for (int n = 0; n < toFind.length; n++) {
                        if (main[k + m][l + n] != toFind[m][n]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (!isMatch) {
                        break;
                    }
                }

                if (isMatch) {
                    result[0] = k;
                    result[1] = l;
                    return result;
                }
            }
        }

        return result;
    }
}
