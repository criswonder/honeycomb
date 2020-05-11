package com.hongyun.hc.wangzheng.pe.day2;

import org.junit.Assert;
import org.junit.Test;
import utils.PrintUtils;

//https://leetcode-cn.com/problems/sliding-window-maximum/
public class SlideWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            if (nums[i] > result[0]) {
                result[0] = nums[i];
            }
        }

        int l = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > result[l - 1]) result[l] = nums[i];
            else {
                //如果上一个窗口的第一个数字不是最大值，那最大值肯定在当前窗口，也就是上一个窗口的最大值
                if (nums[i - k] < result[l - 1]) {
                    result[l] = result[l - 1];
                } else {
                    //遍历当前窗口的k个数字。从窗口的尾部开始遍历
                    for (int j = 0; j < k; j++) {
                        if (result[l] < nums[i - j]) {
                            result[l] = nums[i - j];
                        }
                    }
                }
            }
            l++;
        }

        return result;
    }

    @Test
    public void testMaxSlidingWindow() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        PrintUtils.printArray(maxSlidingWindow(nums, 3));
    }

    @Test
    public void testMaxSlidingWindow2() {
        int[] nums = new int[]{1, -1};
        PrintUtils.printArray(maxSlidingWindow(nums, 1));
    }

    @Test
    public void testMaxSlidingWindow3() {
        int[] nums = new int[]{7, 2, 4};
        int[] result = maxSlidingWindow(nums, 2);
        Assert.assertArrayEquals(new int[]{7, 4}, result);
    }
}
