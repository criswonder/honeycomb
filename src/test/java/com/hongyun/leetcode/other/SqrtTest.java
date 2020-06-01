package com.hongyun.leetcode.other;

import org.junit.Test;

public class SqrtTest {
    //https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    @Test
    public void testMySqrt() {
        assert mySqrt(4) == 2;
        assert mySqrt(17) == 4;
    }
}
