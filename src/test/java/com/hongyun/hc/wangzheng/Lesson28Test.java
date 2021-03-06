package com.hongyun.hc.wangzheng;

import com.hongyun.Lesson28HeapSort;
import org.junit.Test;
import org.junit.Assert;

public class Lesson28Test {

    @Test
    public void testHeapRemoveMax() {
        Lesson28HeapSort.Heap heap = new Lesson28HeapSort.Heap(3);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);

        heap.removeMax();

        assert heap.a[1] == 2;
    }

    @Test
    public void testHeapSort() {
        int a[] = {0, 2, 1, 5, 4, 3};

        Lesson28HeapSort.Heap heap = new Lesson28HeapSort.Heap(a.length);
        heap.sort(a, a.length - 1);

        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, a);
    }
}
