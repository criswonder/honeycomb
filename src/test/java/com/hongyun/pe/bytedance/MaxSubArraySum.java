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

    @Test
    public void testMaxProfit() {
        assert maxProfit(new int[]{7, 6, 4, 3, 1}) == 0;
        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5;
    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int preMin = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - preMin;
            if (prices[i] < preMin) preMin = prices[i];
            if (res < p) res = p;
        }
        return res;
    }

    @Test
    public void testMaxProduct() {
//        int res = maxProduct(new int[]{2, 3, -2, 4});
//        System.out.println(res);
//        assert res == 6;
//        assert maxProduct(new int[]{-2, 0, -1}) == 0;
        assert maxProduct(new int[]{-2, 3, -4}) == 24;
    }

    //https://leetcode-cn.com/problems/maximum-product-subarray/
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        int[] maxs = new int[nums.length];
        maxs[0] = nums[0];

        int[] mins = new int[nums.length];
        mins[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i] * maxs[i - 1];
            int b = nums[i] * mins[i - 1];
            int c = nums[i];

            int max = Math.max(c, Math.max(a, b));
            int min = Math.min(c, Math.min(a, b));

            maxs[i] = max;
            mins[i] = min;

            if (res < max) res = max;
        }
        return res;
    }

    @Test
    public void testMaxTurbulenceSize() {
        int res = maxTurbulenceSize2(new int[]{9, 4, 2, 10, 7, 8});
        System.out.println(res);
        assert res == 5;

        int res2 = maxTurbulenceSize2(new int[]{9, 4, 10});
        System.out.println(res2);
        assert res2 == 3;

        res2 = maxTurbulenceSize2(new int[]{9});
        System.out.println(res2);
        assert res2 == 1;
    }

    //https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/qing-xi-yi-dong-de-dong-tai-gui-hua-jie-fa-shi-yon/
    //https://leetcode-cn.com/problems/longest-turbulent-subarray/
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int N = A.length;
        int[] f = new int[N + 1];
        int[] g = new int[N + 1];
        f[1] = 1;
        g[1] = 1;

        int res = 1;
        for (int k = 2; k <= N; k++) {
            if (A[k - 1] > A[k - 2]) {
                f[k] = g[k - 1] + 1;
            } else {
                f[k] = 1;
            }
            if (A[k - 1] < A[k - 2]) {
                g[k] = f[k - 1] + 1;
            } else {
                g[k] = 1;
            }
            res = Math.max(res, f[k]);
            res = Math.max(res, g[k]);
        }
        return res;
    }

    public int maxTurbulenceSize2(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return 1;
        }
        int res = 1;
        int[] descend = new int[a.length];
        int[] ascend = new int[a.length];
        descend[0] = 1;
        ascend[0] = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                ascend[i] = descend[i - 1] + 1;
                descend[i] = 1;
            } else if (a[i - 1] > a[i]) {
                descend[i] = ascend[i - 1] + 1;
                ascend[i] = 1;
            } else {
                ascend[i] = 1;
                descend[i] = 1;
            }
            if (res < ascend[i]) res = ascend[i];
            if (res < descend[i]) res = descend[i];
        }

        return res;
    }
}
