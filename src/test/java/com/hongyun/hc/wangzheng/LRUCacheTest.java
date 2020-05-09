package com.hongyun.hc.wangzheng;

import linkedlist.LRUCache;
import org.junit.Test;

import java.util.LinkedHashMap;

public class LRUCacheTest {
    @Test
    public void testLru() {
        LRUCache cache = new LRUCache(5);
        cache.put(new LRUCache.Node(6));
        cache.put(new LRUCache.Node(7));
        cache.put(new LRUCache.Node(8));
        cache.put(new LRUCache.Node(9));
        cache.put(new LRUCache.Node(10));

        cache.get(7);
        LRUCache.Node head = cache.getHead();
        LRUCache.Node cur = head.next;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }

    }
}
