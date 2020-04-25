package utils;

public class MiscUtils {
    private static String TAG = "MiscUtils";
    private static boolean VERBOSE = true;

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
