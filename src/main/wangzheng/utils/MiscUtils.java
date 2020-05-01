package utils;

public class MiscUtils {
    private static String TAG = "MiscUtils";
    private static boolean VERBOSE = true;

    public static void swap(int[] arr, int a, int b) {
        if (arr[a] == arr[b]) {
            return;
        }
        System.out.println(String.format("begin arr[%d]=%d,arr[%d]=%d", a, arr[a], b, arr[b]));
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
        System.out.println(String.format("end arr[%d]=%d,arr[%d]=%d", a, arr[a], b, arr[b]));
    }
}
