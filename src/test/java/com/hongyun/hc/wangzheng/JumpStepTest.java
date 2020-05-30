package com.hongyun.hc.wangzheng;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
public class JumpStepTest {
    public int numWays(int sum) {
        int[] mem = new int[sum + 1];
        return doNumWays(sum, mem);
    }

    private int doNumWays(int sum, int[] mem) {
        if (sum <= 0) return 1;
        if (sum == 1) return 1;
        if (sum == 2) return 2;
        if (sum == 3) return 3;
        if (sum == 5) return 1 + doNumWays(4, mem);
//        if (sum == 2) return 2;
        if (mem[sum] > 0) return mem[sum];
        int res = (doNumWays(sum - 1, mem) + doNumWays(sum - 2, mem)) % 1000000007;
        mem[sum] = res;
        return res;
    }

    private int[] memo;

    public int numWays2(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return jump(n);
    }

    private int jump(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        memo[n] = (jump(n - 1) + jump(n - 2)) % 1000_000_007;
        return memo[n];
    }

    public int dpJump(int num) {
        int pre1 = 1, pre2 = 2;
        for (int i = 3; i < num + 1; i++) {
            int tmp = pre1 + pre2;
            pre1 = pre2;
            pre2 = tmp;
        }
        return pre2;
    }

    @Test
    public void testJump() {
//        System.out.println(numWays(50));
        System.out.println(numWays2(8));
        System.out.println(dpJump(8));
//        System.out.println(Integer.MAX_VALUE);
    }
}
