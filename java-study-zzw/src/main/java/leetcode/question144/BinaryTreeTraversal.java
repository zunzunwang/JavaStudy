package leetcode.question144;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zunzunwang
 * Date: 18/07/2022
 * 二叉树的遍历
 * Preorder
 * Inorder
 * Postorder
 */
public class BinaryTreeTraversal {
    /**
     * 前序 根结点->左子树->右子树
     * @param root
     * @return
     *
     * 非递归算法 使用stack来记录
     * 先出栈当前元素， 并入栈右节点，左节点如果非空。
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }

        while(stack.size() > 0) {
            //pop the first value;
            TreeNode tn = stack.pop();
            result.add(tn.val);

            if(tn.right != null) {
                stack.push(tn.right);
            }

            if(tn.left != null) {
                stack.push(tn.left);
            }
        }

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode tn = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while(tn != null || !stack.isEmpty()) {
            if (tn != null){
                result.add(tn.val);
                stack.push(tn);
                tn = tn.left;
            } else {
                tn = stack.pop();
                tn = tn.right;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root, ArrayList arrayList) {
        arrayList.add(root.val);

        if (root.left != null) {
            preorderTraversalRecursive(root.left, arrayList);
        }

        if (root.right != null) {
            preorderTraversalRecursive(root.right, arrayList);
        }
        return arrayList;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        TreeNode tn = root;

        while(tn != null || !stack.isEmpty()) {
            if(tn != null){
                stack.push(tn);
                tn = tn.left;
            } else {
                tn = stack.pop();
                result.add(tn.val);
                tn = tn.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        return null;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        return null;
    }


    public static void main(String[] args) {
        /**
         *          4
         *        /   \
         *      2       6
         *    /   \   /   \
         *   1     3 5     7
         */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.add(n2);
        n4.add(n6);
        n4.add(n1);
        n4.add(n3);
        n4.add(n5);
        n4.add(n7);
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("preordertravesal: " + binaryTreeTraversal.preorderTraversal(n4));
        System.out.println("inordertravesal: " + binaryTreeTraversal.inorderTraversal(n4));

    }
}
