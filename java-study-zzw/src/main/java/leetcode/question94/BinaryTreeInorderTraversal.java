package leetcode.question94;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *       Link: <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 *       Description
 *       Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *       Example 1:
 *       Input: root = [1,null,2,3]
 *       Output: [1,3,2]
 *       Example 2:
 *       Input: root = []
 *       Output: []
 *       Example 3:
 *       Input: root = [1]
 *       Output: [1]
 *       Constraints:
 *       The number of nodes in the tree is in the range [0, 100].
 *       -100 <= Node.val <= 100
 */

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursive(root, result);
        return result;
    }

    private static void inorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversalRecursive(node.left, result);
            result.add(node.val);
            inorderTraversalRecursive(node.right, result);
        }
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        //push and move to left, pop and move to right
        List<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while(currentNode != null || !stack.isEmpty()) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;

        System.out.println("Recursive: " + BinaryTreeInorderTraversal.inorderTraversalRecursive(t1));
        System.out.println("Iterative: " + BinaryTreeInorderTraversal.inorderTraversalIterative(t1));
    }
}
