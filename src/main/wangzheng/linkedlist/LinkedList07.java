package linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * <p>
 * Andymao
 * 测试的方法名称都加上andy后缀
 * <p>
 * Author: Zheng
 */
public class LinkedList07 {
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next.data +
                    '}';
        }
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String args[]) {
//        Node listA = createListA();
//        printAll(listA);
//        Node reversed = reverseListAndy(listA);
//        System.out.println("reversed:");
//        printAll(reversed);
//
        testMergeList();
//
//        testCircleList();

//        deleteLinkedListKthNode();

//        findMiddleNode();
    }

    private static void testCircleList() {
        System.out.println("检测链表中的环：");
        Node circleList = createCircleList();
//        printAll(circleList);
//        System.out.println(checkCircle(circleList));
//        System.out.println(checkCircle(listA));
//
        System.out.println(checkCircleListAndy(circleList));

        Node listA = createListA();
        System.out.println(checkCircleListAndy(listA));
    }

    private static void testMergeList() {
        Node listA = createListA();
        Node listB = createList();
        printAll(listA);
        printAll(listB);

//        printAll(mergeSortedLists(reverse(listA),reverse(listB)));
        System.out.println("合并有序链表listA listB：");
        Node mergedList = mergeListAndy(listA, listB);
        printAll(mergedList);
    }

    private static void reverseList() {
        //test reverse method
        Node listA = createListA();
//        printAll(listA);
//
//        System.out.println("反转链表的结果：");
//        printAll(reverseListAndy(listA));
    }

    private static void findMiddleNode() {
//        Node listA = createListA();
//        printAll(listA);
//        System.out.println("查找链表的中间节点：");
//        Node middleNode = findMiddleNode(listA);
//        System.out.println(middleNode.data);
//
//        middleNode = findMiddleNodeAndy(listA);
//        System.out.println(middleNode.data);

        Node listEven = createListAEven();
        printAll(listEven);
        System.out.println("查找链表的中间节点：");
        Node middleNode = findMiddleNode(listEven);
        System.out.println(middleNode.data);

        middleNode = findMiddleNodeAndy(listEven);
        System.out.println(middleNode.data);
    }

    public static Node createList() {
        Node n10 = new Node(10, createNode(11));
        Node n9 = new Node(9, n10);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);

        return n5;
    }

    public static Node createListA() {
        Node n8 = new Node(8, createNode(9));
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);

        return n3;
    }

    /**
     * Even or odd
     *
     * @return
     */
    public static Node createListAEven() {
        Node n10 = new Node(10, null);
        Node n9 = new Node(9, n10);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);

        return n3;
    }

    public static Node createCircleList() {
        Node node = createNode(9);
        Node n8 = new Node(8, node);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);

        node.next = n5;

        return n3;
    }

    private static void deleteLinkedListKthNode() {
        Node list = createList();
        int k = 31;
//        System.out.println(String.format("删除倒数第%d个节点：", k));
//        printAll(list);
//        deleteLastKthAndy(list, k);
//        System.out.println(String.format("删除后："));
//        printAll(list);

        k = 3;
        System.out.println(String.format("删除倒数第%d个节点：", k));
        printAll(list);
        Node node = deleteLastKthAndy(list, k);
        System.out.println(String.format("删除后："));
        printAll(node);
    }

    public static Node deleteLastKthAndy(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast.next != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (i < k - 1) return list;

        Node prev = null;
        Node slow = list;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            return slow.next;
        } else {
            prev.next = prev.next.next;
            return list;
        }
    }

    public static Node reverseListAndy(Node list) {
        Node head = null;
        if (list == null || list.next == null) return list;
        Node prev = null, cur = list, next = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                head = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return head;
    }

    public static Node mergeListAndy(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;
        Node head;
        Node i = la, j = lb, k;
        if (la.data < lb.data) {
            head = la;
            i = la.next;
        } else {
            head = lb;
            j = lb.next;
        }
        k = head;

        while (i != null && j != null) {
            if (i.data < j.data) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }
            k = k.next;
        }

        if (i == null) k.next = j;
        if (j == null) k.next = i;

        return head;
    }

    public static Node findMiddleNodeAndy(Node list) {
        if (list == null) {
            return null;
        }

        Node slow = list;
        Node fast = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static boolean checkCircleListAndy(Node list) {
        if (list == null || list.next == null) return false;
        Node fast = list, slow = list;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast.equals(slow)) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }


    public static Node reverse(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }

    // 有序链表合并; 链表是升序排列的
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        //走到这里说明有一个链表已经用完了
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    public static boolean checkCircle(Node list) {
        if (list == null) return false;
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * //推演一下边界情况：
     * list只有3个元素，删除K=4
     * <p>
     * fast = 第二个元素
     * i = 2
     * <p>
     * fast = 第三个元素
     * i=3
     * <p>
     * fast = 第四个元素 (空)
     * i=4
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        //i 1->k-1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        //仔细理解一下这里，如果fast为空，说明list不够长，所以K值超出了list的长度，不需要删除list的任何数据
        if (fast == null) return list;

        //因为fast先走了k-1步，所以fast在第正数第k个点，剩下n-k个点 （fast的目标是走到最后一个点）
        //slow在和fast一样走了n-k步的时候，slow所在的位置是顺数n-k+1的位置。那么slow所在位置的后面还有 n-(n-k+1)个点
        //合并多项式，也就是k-1个点。slow的后面还有k-1个点，那就是说slow在倒数第k个位置。

        /**
         *推演一下5个元素，要删除倒数第4个的情况
         * k=4
         * i的可能取值是1,2,3
         * 在运行完第一个while循环fast将走到第4个位置
         *
         */
        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            //这个情况就是，3个元素的list，删除k=3的元素
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        //推演一下list有四个元素的情况
        //第一次循环
        //fast = 第三个元素
        //slow = 第二个元素

        //第二次循环
        //直接退出了，因为fast.next.next = null
        //所以slow = 第二个元素
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


}