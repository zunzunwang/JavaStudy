package leetcode.question110;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一棵树是不是高平衡二叉树
 */
//16/02/2019
public class BalancedBinaryTree {

    //在这个例子中必须保证所有的点都被验证过是平衡的。
    //所以不能光比较一个跟根的两个子节点的最大深度是否一样
    //这里理清了一个问题 java的传参问题
    /**
     * java始终是值传递 对于基本变量， 传递的是值的拷贝， 对于对象。传递的是指针的拷贝
     * 所以即使穿得是对象 但是在代码中对指针进行了修改，除非引起object自身的改变否则
     * 函数外始终指向的是原先的object
     */
    public Boolean label;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        label = new Boolean(true);
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth ) > 1){
            label = false;
        }
        return label;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth)  > 1){
            label = false;
        }

        return 1 + Math.max(leftDepth, rightDepth);
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