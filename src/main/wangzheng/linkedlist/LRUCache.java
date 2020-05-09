package linkedlist;

public class LRUCache {
    int capacity;
    int num;
    Node head;

    public static class Node {
        public int data;
        public Node prev, next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node getHead() {
        return head;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(Integer.MIN_VALUE);
    }

    public void put(Node node) {
        if (num == capacity) {
            Node pre = head;
            Node cur = head.next;
            while (cur != null && cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        } else {
            num++;
        }

        //插入节点到队头
        node.next = head.next;
        if (head.next != null) {
            head.next.prev = node;
        }

        node.prev = head;

        head.next = node;
    }

    public void get(int num) {
        Node pre = head;
        Node cur = head.next;
        while (cur != null && cur.next != null) {
            if (cur.data == num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        cur.next.prev = pre;

        //插入节点到队头
        cur.next = head.next;
        head.next.prev = cur;
        cur.prev = head;

        head.next = cur;
    }
}
