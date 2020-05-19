package com.hongyun.pe.bytedance;

import com.hongyun.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Practice {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int data) {
            this.val = data;
        }

    }

    /**
     *       20
     *      /  \
     *     10   30
     *    / \   / \
     *   9  15 25 35
     * @return
     */
    private TreeNode getTestData() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(25);
        TreeNode node6 = new TreeNode(35);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }

    private int[] expectsPostOrder = new int[]{9, 15, 10, 25, 35, 30, 20};
    private int[] expectsPreOrder = new int[]{20, 10, 9, 15, 30, 25, 35};
    private int[] expectsInOrder = new int[]{9, 10, 15, 20, 25, 30, 35};

    @Test
    public void testNonRecursivePostOrder() {
        TreeNode root = getTestData();
        List<Integer> integers = postOrderTraversal(root);

        int[] results = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            results[i] = integers.get(i);
        }
        Assert.assertArrayEquals(expectsPostOrder, results);
    }

    @Test
    public void testNonRecursiveInOrder() {
        TreeNode root = getTestData();
        List<Integer> integers = inOrderTraversal(root);

        int[] results = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            results[i] = integers.get(i);
        }
        Assert.assertArrayEquals(expectsInOrder, results);
    }

    @Test
    public void testNonRecursivePreOrder() {
        TreeNode root = getTestData();
        List<Integer> integers = preOrderTraversal(root);

        int[] results = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            results[i] = integers.get(i);
        }
        Assert.assertArrayEquals(expectsPreOrder, results);
    }

    @Test
    public void testLevelTraversal() {
        List<List<Integer>> lists = levelTraversal(getTestData());
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    // 非递归前序遍历
    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return result;
    }

    // 非递归中序遍历
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }

        return result;
    }

    // 非递归后序遍历
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode p = root, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.right == null || p.right == pre) {
                    result.add(p.val);
                    pre = p;
                    p = null;
                } else {
                    stack.push(p);
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                }
            }
        }
        return result;
    }

    // 非递归层次遍历
    public List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                line.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(line);
        }

        return res;
    }
}
