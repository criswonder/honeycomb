package com.hongyun.leetcode.other;

import org.junit.Test;

import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Wrapper implements Comparable {
        int val;
        ListNode node;

        public Wrapper(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper wrapper = (Wrapper) o;
            return val == wrapper.val &&
                    node.equals(wrapper.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, node);
        }

        @Override
        public int compareTo(Object o) {
            Wrapper wrapper = (Wrapper) o;
            return val - wrapper.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<Wrapper> queue = new PriorityQueue(k);
        for (int i = 0; i < k; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.add(new Wrapper(node.val, node));
                node = node.next;
            }
        }

        ListNode result = null;
        ListNode resultCur = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll().node;
//            if (node != null) System.out.println("val=" + node.val);
            if (result == null) {
                result = node;
                resultCur = result;
            } else {
                resultCur.next = node;
                resultCur = resultCur.next;
            }

            if (node.next != null) queue.add(new Wrapper(node.next.val, node.next));
        }

        return result;
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(1);
        queue.add(2);
        queue.add(0);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    @Test
    public void testMergeKLists() {
        ListNode[] nodeLists = new ListNode[3];

        //list1
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(22);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //list2
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(7);
        ListNode node24 = new ListNode(8);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        //list3
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        ListNode node34 = new ListNode(6);
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;

        nodeLists[0] = node1;
        nodeLists[1] = node21;
        nodeLists[2] = node31;

        ListNode node = mergeKLists(nodeLists);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
