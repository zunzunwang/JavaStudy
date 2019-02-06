package swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFSBinaryTree {
    //二叉树中序遍历 LDR打印
    //前序遍历 DLR
    //后序遍历 RDL
    //非递归算法实现借助一个queue来实现
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            //1.创建辅助队列和结果队列或者结果数组
            ArrayList<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            //2.将根元素加入队列
            queue.offer(root);


            //对辅助队列进行循环
            while(!queue.isEmpty()) {
                //获取本层的元素个数
                Integer levelSize = queue.size();

                //对每个node进行查找儿子
                for (int i = 0; i < levelSize; i++){
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    res.add(node.val);
                }
            }
            return res;
        }
    }

    //with recursive method.
    public ArrayList<Integer> PrintFromTopToBottomRecursive(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            //create save list
            List<List<TreeNode>> nodeList = new ArrayList<>();
            dfs(root, 0, nodeList);

            //final result
            ArrayList<Integer> res = toArray(nodeList);
            return res;
        }
    }

    public void dfs(TreeNode node, Integer level, List<List<TreeNode>> nodeList){
        if (nodeList.size() < (level + 1)){
            //create the new level List
            List<TreeNode> levelList = new ArrayList<>();
            levelList.add(node);
            nodeList.add(levelList);
        } else {
            nodeList.get(level).add(node);
        }

        if (node.left != null) {
            dfs(node.left, level + 1, nodeList);
        }

        if (node.right != null) {
            dfs(node.right, level + 1, nodeList);
        }
    }


    public ArrayList<Integer> toArray(List<List<TreeNode>> nodeList){
        ArrayList<Integer> res = new ArrayList<>();

        for (List<TreeNode> levelList : nodeList){
           for (TreeNode node: levelList){
               res.add(node.val);
           }
        }
        return res;
    }


    /**
     * preorder traverse
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * inorder traverse
     */
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val+"  ");
            inOrderTraverse1(root.right);
        }
    }

    /**
     * postorder traverse
     */
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val+"  ");
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


}
