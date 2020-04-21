package dynamic_programming;

/**
 * 2,9,3,6,5,1,7
 * 输出：2,3,5,7 len=4
 */
public class Exercise42 {
    public int maxAscendSequence = 1;
    public int[] array1 = {2, 9, 3, 6, 5, 1, 7, 8, 1, 2, 3, 9};

    public static void main(String[] args) {
        Exercise42 exercise = new Exercise42();
        exercise.find(0, 2, 1);
        System.out.println("maxAscendSequence=" + exercise.maxAscendSequence);
        System.out.println("maxAscendSequence=" + exercise.longestIncreaseSubArrayDP(exercise.array1));
    }

    public void find(int i, int lastElement, int seqLen) {
        if (i >= array1.length) {
            if (maxAscendSequence < seqLen) {
                maxAscendSequence = seqLen;
            }
            return;
        }

        if (array1[i] > lastElement) {
            find(i + 1, array1[i], seqLen + 1);
        }
        find(i + 1, lastElement, seqLen);
    }

    public int longestIncreaseSubArrayDP(int[] array) {
        if (array.length < 2) return array.length;
        int[] state = new int[array.length];
        state[0] = 1;
        for (int i = 1; i < state.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    if (state[j] > max) max = state[j];
                }
            }
            state[i] = max + 1;
        }
        int result = 0;
        for (int i = 0; i < state.length; i++) {
            if (state[i] > result) result = state[i];
        }
        return result;
    }
}
