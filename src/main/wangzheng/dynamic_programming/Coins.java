package dynamic_programming;

import java.util.Arrays;

/**
 * 我们今天来看一个新的硬币找零问题。假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
 * 如果我们要支付 w 元，求最少需要多少个硬币。比如，我们有 3 种不同的硬币，1 元、3 元、5 元，
 * 我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）
 */
//https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
public class Coins {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int num = amount;
//        boolean a[][] = new boolean[num][amount + 1];
        //eg: {true,true,false,false} 表示金额是0、1
        boolean state[] = new boolean[amount + 1];


        //放置第一个硬币，所有金额的硬币都可以放
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= amount) state[coins[j]] = true;
        }

        //检测是否放了一个硬币就ok了
        if (state[amount]) return 1;

        //开始放置硬币,最坏情况可能会放置amount个
        for (int l = 1; l < amount; l++) {
            boolean[] lastState = new boolean[amount + 1];
            System.arraycopy(state, 0, lastState, 0, amount + 1);

            for (int j = 0; j < coins.length; j++) {
                for (int k = state.length - 1 - coins[j]; k >= 0; k--) {
                    if (lastState[k]) {
                        int curAmount = k + coins[j];
                        state[curAmount] = true;
                        if (curAmount == amount) return l + 1;
                    }
                }
            }
        }
        return -1;
    }

    public int coins(int sum) {
        if (sum == 1) return 1;
        if (sum == 2) return 2;
        if (sum == 3) return 2;
        if (sum == 4) return 2;
        if (sum == 5) return 1;
        return Math.min(coins(sum - 1), Math.min(coins(sum - 3), coins(sum - 5))) + 1;
    }


    public int coinChange3(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinsGreedy(int sum) {
        int fives = sum / 5;
        int threes = (sum - fives * 5) / 3;
        int ones = sum - fives * 5 - threes * 3;
        return fives + threes + ones;
    }

    //贪心算法思想是行不通的。会导致找不到答案。
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int sum = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (i == 0) {
                int r = amount % coins[i];
                if (r > 0) return -1;
            }
            int n = amount / coins[i];
            sum += n;
            amount -= coins[i] * n;

        }

        if (sum == 0) return -1;
        return sum;
    }
}
