package leetcode.question102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//16/02/2019
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //null condition
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //int indexLevel = 1;
        while (!queue.isEmpty()) {
            /**
             * 重点在这句获取每行元素的个数！之后对个数进行循环
             */
            int levelElementNumber = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelElementNumber; i++) {
                TreeNode n = queue.poll();
                levelList.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
            result.add(levelList);
            //indexLevel++;
        }
        return result;
    }

    public List<List<Integer>> levelOrderRecusive(TreeNode root) {
        //创建结果列表
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //传入的参数为结果列表 根结点和高度。 开始递归。
        levelHelper(res, root, 0);
        return res;
    }

    //是一个空函数
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        //判断层列表的条件。 如果层已经被初始化过则跳过直接添加
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }

        //之后添加自己这个点 然后再添加自己的左右孩子 并且保证更新高度。
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
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