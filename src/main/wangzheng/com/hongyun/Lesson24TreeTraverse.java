package com.hongyun;

public class Lesson24TreeTraverse {
    public static void main(String[] args) {
        Node tree = getTree();
        Lesson24TreeTraverse lesson24 = new Lesson24TreeTraverse();
        lesson24.tree = tree;

//        //查找节点
//        Node node = lesson24.find(66);
//        System.out.println(node.data);
//
//        //中序遍历
//        lesson24.middleTraverse(tree);

        //树的高度
        System.out.println("height="+lesson24.getTreeHeight(tree));
    }

    private static Node getTree() {
        Node node = new Node(33);
        Node node1 = new Node(16);
        Node node12 = new Node(50);
        Node node21 = new Node(15);
        Node node22 = new Node(19);
        Node node23 = new Node(34);
        Node node24 = new Node(58);
        Node node31 = new Node(17);
        Node node32 = new Node(25);
        Node node33 = new Node(51);
        Node node34 = new Node(66);
        Node node41 = new Node(27);
        node.left = node1;
        node.right = node12;
        node1.left = node21;
        node1.right = node22;
        node12.left = node23;
        node12.right = node24;

        node22.left = node31;
        node22.right = node32;
        node24.left = node33;
        node24.right = node34;

        node32.right = node41;
        return node;
    }

    private Node tree;

    public int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(node.right), getTreeHeight(node.left));
    }
    public void middleTraverse(Node node) {
        if (node.left != null) {
            middleTraverse(node.left);
        }

        System.out.println(node.data);
        if (node.right != null) {
            middleTraverse(node.right);
        }
    }
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }
}
