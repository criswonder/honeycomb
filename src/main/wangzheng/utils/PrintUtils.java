package utils;

public class PrintUtils {
    public static void main(String[] args) {
        boolean[][] matrix = {{true, false, false}, {true, false, true}};
        PrintUtils.printMatrix(matrix);
    }


    public static void printMatrix(boolean[][] matrix) {
        int iLen = matrix.length;
        int jLen = matrix[0].length;
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                System.out.printf(String.format("%10s", matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static <T extends Object> void printArray(T[] array) {
        if (array == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i);
        }

        System.out.println(sb.toString());
    }

    public static void printArray(int[] array) {
        if (array == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }

    public static void printArrayReverse(int[] array) {
        if (array == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }
}
