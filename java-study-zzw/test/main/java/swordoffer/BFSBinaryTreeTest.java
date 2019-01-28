package swordoffer;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BFSBinaryTreeTest extends TestCase {
    BFSBinaryTree.TreeNode n1 = new BFSBinaryTree.TreeNode(1);
    BFSBinaryTree.TreeNode n2 = new BFSBinaryTree.TreeNode(2);
    BFSBinaryTree.TreeNode n3 = new BFSBinaryTree.TreeNode(3);
    BFSBinaryTree.TreeNode n4 = new BFSBinaryTree.TreeNode(4);
    BFSBinaryTree.TreeNode n5 = new BFSBinaryTree.TreeNode(5);
    BFSBinaryTree.TreeNode n6 = new BFSBinaryTree.TreeNode(6);
    BFSBinaryTree.TreeNode n7 = new BFSBinaryTree.TreeNode(7);
    BFSBinaryTree.TreeNode n8 = new BFSBinaryTree.TreeNode(8);
    BFSBinaryTree.TreeNode n9 = new BFSBinaryTree.TreeNode(9);

    public BFSBinaryTreeTest() {
        //init tree
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.right = n9;
    }

    @Test
    public void testPrintFromTopToBottom() {
        BFSBinaryTree bfsBinaryTree = new BFSBinaryTree();
        Integer[] answerArray = {new Integer(1), new Integer(2), new Integer(3), new Integer(4),
                new Integer(5), new Integer(6), new Integer(7), new Integer(8), new Integer(9)};
        ArrayList<Integer> answerArrayList = new ArrayList<Integer>(Arrays.asList(answerArray));
        assertEquals(answerArrayList, bfsBinaryTree.PrintFromTopToBottom(n1));
    }


    @Test
    public void testPrintFromTopToBottomRecursive() {
        BFSBinaryTree bfsBinaryTree = new BFSBinaryTree();
        Integer[] answerArray = {new Integer(1), new Integer(2), new Integer(3), new Integer(4),
                new Integer(5), new Integer(6), new Integer(7), new Integer(8), new Integer(9)};
        ArrayList<Integer> answerArrayList = new ArrayList<Integer>(Arrays.asList(answerArray));
        assertEquals(answerArrayList, bfsBinaryTree.PrintFromTopToBottomRecursive(n1));
    }

    /*
    @Test
    public void dfs() {

    }

    @Test
    public void toArray() {

    }
    */
}