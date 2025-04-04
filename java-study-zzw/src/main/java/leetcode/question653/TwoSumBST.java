package leetcode.question653;

/**
 * Created by zunzunwang
 * Date: 2019-03-21
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal
 * to the given target.
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 * <p>
 * Solution1:
 * Using HashSet + DFS
 * Time complexity : O(n)O(n)O(n). The entire tree is traversed only once in the worst case. Here,
 * nnn refers to the number of nodes in the given tree.
 * Space complexity : O(n)O(n)O(n). The size of the setsetset can grow upto nnn in the worst case.
 *
 * <p>
 * Solution2:
 * Using HashSet + BFS
 *
 * Time complexity : O(n)O(n)O(n). We need to traverse over the whole tree once in the worst case. Here, nnn refers to the number of nodes in the given tree.
 * Space complexity : O(n)O(n)O(n). The size of the setsetset can grow atmost upto nnn.
 *
 * <p>
 * Solution3:
 * Using inorder and transfer the tree to the array and use previous function
 */
public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        //init
        if (root == null) {
            return false;
        }

        HashSet<Integer> set = new HashSet();
        return dfsFind(root, k, set);
    }

    public boolean dfsFind(TreeNode node, int k, HashSet set) {
        //init
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        } else {
            set.add(node.val);
            return dfsFind(node.left, k, set) || dfsFind(node.right, k, set);
        }
    }

    public boolean bfsFind(TreeNode node, int k, HashSet set){
        //init
        if(node == null){
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList();
        queueNode.offer(node);

        while(!queueNode.isEmpty()){
            TreeNode nodeTmp = queueNode.poll();
            if(set.contains(k - nodeTmp.val)){
                return true;
            } else {
                set.add(nodeTmp.val);
                if(nodeTmp.left != null){
                    queueNode.offer(nodeTmp.left);
                }

                if(nodeTmp.right != null){
                    queueNode.offer(nodeTmp.right);
                }
            }
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
