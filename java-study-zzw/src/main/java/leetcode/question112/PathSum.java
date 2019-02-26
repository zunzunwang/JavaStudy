package leetcode.question112;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 17/02/2019
 * 计算是不是有一个路径上所有节点的和等于给定值
 */
public class PathSum {
    //考虑到有可能val为负值的情况所以不能单纯以 val>sum作为判断的标准。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return calculateSum(root, 0, sum);
    }

    public boolean calculateSum(TreeNode node, int sumTmp, int sumTarget) {
        if (node == null) {
            return sumTarget == sumTmp;
        }

        boolean leftResult = false;
        boolean rightResult = false;

        if (node.left != null) {
            leftResult = calculateSum(node.left, node.val + sumTmp, sumTarget);
        }

        if (node.right != null) {
            rightResult = calculateSum(node.right, node.val + sumTmp, sumTarget);
        }

        if (node.left == null && node.right == null) {
            return node.val + sumTmp == sumTarget;
        }

        return leftResult || rightResult;

    }

}
