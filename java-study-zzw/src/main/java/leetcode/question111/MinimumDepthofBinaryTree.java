package leetcode.question111;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//16/02/2019

/**
 * 求二叉树的最小值。 要注意如果一个孩子为空一个孩子为非空需要继续遍历非空的孩子。
 *
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null || root.right != null) {
            if(root.left == null)
                return 1 + minDepth(root.right);
            if(root.right == null)
                return 1 + minDepth(root.left);
            return 1 + Math.min(minDepth(root.right), minDepth(root.left));
        } else {
            return 1;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }



}
