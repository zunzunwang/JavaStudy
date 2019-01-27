package swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public ArrayList<Integer> PrintFromTopToBottomRecusive(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            ArrayList<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                Integer levelSize = queue.size();
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


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
