package com.hongyun.hc.wangzheng;

import dynamic_programming.Coins;
import org.junit.Test;

public class CoinsTest {
    @Test
    public void testCoins3() {
        Coins coins = new Coins();
        int i = coins.coinChange(new int[]{1}, 1);
        assert i == 1;

        i = coins.coinChange(new int[]{1, 2}, 2);
        assert i == 1;

        i = coins.coinChange(new int[]{1, 2, 5}, 11);
        assert i == 3;

        i = coins.coinChange(new int[]{186, 419, 83, 408}, 6249);
        assert i == 20;

        i = coins.coinChange(new int[]{3}, 4);
        assert i == -1;
    }
}
