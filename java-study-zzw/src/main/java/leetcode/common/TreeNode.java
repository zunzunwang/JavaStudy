package leetcode.common;

/**
 * Created by zunzunwang
 * Date: 18/07/2022
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void add(TreeNode n) {
        if (n != null) {
            if(n.val > this.val) {
                if(this.right != null) {
                    this.right.add(n);
                } else {
                    this.right = n;
                }
            } else if (n.val < this.val) {
                if(this.left != null) {
                    this.left.add(n);
                } else {
                    this.left = n;
                }
            }
        }
    }
}
