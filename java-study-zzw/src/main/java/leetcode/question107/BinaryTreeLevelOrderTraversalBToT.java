package leetcode.question107;

import java.util.ArrayList;
import java.util.List;

//16/02/2019
public class BinaryTreeLevelOrderTraversalBToT {
    //方法一， 使用旧的BFS借助queue来实现。
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int level = 0;
        levelOrderBottomHelper(res, root, level);
        return res;
    }

    public void levelOrderBottomHelper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null){
            return;
        }
        if (res.size() < level + 1) {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            res.add(0, levelList);
        } else {
            //size -level -1
            res.get(res.size() - level - 1).add(root.val);
        }

        levelOrderBottomHelper(res, root.left, level + 1);
        levelOrderBottomHelper(res, root.right, level + 1);
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
