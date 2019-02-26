package leetcode.question104;

import java.util.LinkedList;
import java.util.Queue;

//16/02/2019
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize =  queue.size();
            TreeNode n;
            for (int i = 0; i < levelSize; i++){
                n = queue.poll();
                if (n.left != null){
                    queue.offer(n.left);
                }
                if (n.right != null){
                    queue.offer(n.right);
                }
            }
            result++;
        }
        return result;
    }

    public int maxDepthRecusive(TreeNode root){
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecusive(root.left), maxDepthRecusive(root.right));
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
