package pe.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = null;
        lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

        lists = solution.threeSum(new int[]{0, 0, 0, 0});
        System.out.println(lists);

        lists = solution.threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(lists);
    }

    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) return result;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
                int target = -nums[i];
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int num1 = nums[j];
                    int num2 = nums[k];
                    int sum = num1 + num2;
                    if (sum == target) {
                        List<Integer> line = new ArrayList<>();
                        line.add(nums[i]);
                        line.add(num1);
                        line.add(num2);
                        result.add(line);
                        j++;
                        k--;
                        while (j < k && nums[j] == num1) j++;
                        while (k > j && nums[k] == num2) k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return result;
        }
    }

}
