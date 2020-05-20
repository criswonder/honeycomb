package com.hongyun.pe.bytedance;

import org.junit.Test;

//https://leetcode-cn.com/problems/maximum-subarray/
public class MaxSubArraySum {

    @Test
    public void tc1() {
        int[] a = new int[]{9, 8, 7, -10, -19, 9, -1, 1, 9, 9};
        System.out.println(MaxSubArray(a));
    }

    public int MaxSubArray(int[] nums) {
        int pre = nums[0], maxAns = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
//            if (sum + num > num) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
