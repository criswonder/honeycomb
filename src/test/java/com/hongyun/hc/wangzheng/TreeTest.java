package com.hongyun.hc.wangzheng;

import com.hongyun.Tree;
import org.junit.Test;

import java.util.List;

public class TreeTest {
    @Test
    public void testTreeHeight() {
        Tree.Node node = new Tree.Node(8);
        node.left = new Tree.Node(9);
        int h = Tree.getTreeH(node);
        int h1 = Tree.getTreeHeight(node);
        System.out.println(h1);
        System.out.println(h);
    }

    @Test
    public void testLevelPrint() {
        Tree.Node tree = Tree.getTree();
        levelPrint(tree);
    }

    private void levelPrint(Tree.Node root) {
        List<List<Tree.Node>> lists = Tree.levelPrint(root);
        for (List<Tree.Node> list : lists) {
            for (Tree.Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testInsertion() {

        //二叉树的插入和堆是有区别的，感觉节点没有动态的变动
        Tree.Node node = new Tree.Node(7);
        Tree.insert(node, 9);
        Tree.insert(node, 8);

        Tree.insert(node, 6);
        Tree.insert(node, 5);
        Tree.insert(node, 10);

        levelPrint(node);
    }

    @Test
    public void testDelete() {
        //删除的节点只有一个left节点
        Tree.Node node = new Tree.Node(7);
        Tree.insert(node, 6);
        Tree.insert(node, 5);

        assert node.left.data == 6;
        assert node.left.left.data == 5;

        Tree.delete(node,6);
        assert node.left.data == 5;

        //删除的节点只有一个right节点
        Tree.Node node2 = new Tree.Node(7);
        Tree.insert(node2, 2);
        Tree.insert(node2,9);
        Tree.insert(node2,10);

        Tree.delete(node2,9);
        assert node2.right.data == 10;
    }

    @Test
    public void deleteTwoChildren() {
        //删除的节点有两个字节点
        Tree.Node node3 = new Tree.Node(2);
        Tree.insert(node3,5);
        Tree.insert(node3,7);
        Tree.insert(node3,6);
        Tree.insert(node3,15);
        Tree.insert(node3,10);
        Tree.insert(node3,8);
        Tree.insert(node3,11);
        Tree.insert(node3,16);

        System.out.println(node3);
        levelPrint(node3);

        System.out.println();
        Tree.delete(node3,7);
        levelPrint(node3);
    }

    @Test
    public void testRevertTree(){
//        Tree.Node node3 = new Tree.Node(7);
//        Tree.insert(node3,5);
//        Tree.insert(node3,10);
//        levelPrint(node3);
//        Tree.invertNode(node3);
//        levelPrint(node3);

        Tree.Node node = Tree.getTree();
        levelPrint(node);
        Tree.invertNode(node);
        levelPrint(node);
    }
}
