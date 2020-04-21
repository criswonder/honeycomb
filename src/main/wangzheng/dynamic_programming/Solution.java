package dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(6);

        TreeNode left11 = new TreeNode(7);
        TreeNode left12 = new TreeNode(8);

        TreeNode left121 = new TreeNode(9);
        TreeNode left122 = new TreeNode(18);

        root.left = left1;
        root.right = left2;

        left1.left = left11;
        left1.right = left12;

        left12.left = left121;
        left12.right = left122;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);

    }

    LinkedList<TreeNode> myQueue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList();
        List<Integer> line;
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            int count = myQueue.size();
            line = new ArrayList<Integer>();
            while (count > 0) {
                count--;

                TreeNode node = myQueue.pop();
                line.add(node.val);

                if (node.left != null) {
                    myQueue.add(node.left);
                }

                if (node.right != null) {
                    myQueue.add(node.right);
                }
            }
            result.add(line);
        }
        return result;
    }
}
