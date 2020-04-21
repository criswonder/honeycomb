package binarysearch;

public class BinarySearch15 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 7, 8, 9, 20, 32};
        int index = binarySearch(arr, arr.length, 8);
        System.out.println("index=" + index + ",value=" + arr[index]);

        index = binarySearch(arr, arr.length, 9);
        System.out.println("index=" + index);

        index = binarySearch(arr, arr.length, 2);
        System.out.println("index=" + index);
    }

    public static int binarySearch(int[] a, int len, int value) {
        if (len == 1) return value == a[0] ? 0 : -1;
        int start = 0, end = len - 1;
        return binarySearchInternal(a, start, end, value);
    }

    private static int binarySearchInternal(int[] a, int start, int end, int value) {
        if (start == end) {
            return a[start] == value ? start : -1;
        }

        int middle = (start + end) / 2;

        if (a[middle] > value) {
            return binarySearchInternal(a, start, middle - 1, value);
        } else if (a[middle] < value) {
            return binarySearchInternal(a, middle + 1, end, value);
        } else {
            return middle;
        }
    }

    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    // 二分查找的递归实现
    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

}
