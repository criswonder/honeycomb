package com.hongyun.hc.wangzheng;

import org.junit.Test;
import utils.MiscUtils;


public class MiscUtilsTest {

    @Test
    public void testSwap() {
        int[] a = {1, 2};
        MiscUtils.swap(a, 0, 1);
        assert a[0] == 2;
        assert a[1] == 1;
    }
}
