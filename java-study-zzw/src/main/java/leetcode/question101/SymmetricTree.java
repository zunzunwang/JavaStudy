package leetcode.question101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }


    public static boolean isSymmetric(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public boolean isSymmetricIteration(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(p);
        s.push(q);
        TreeNode pTmp;
        TreeNode qTmp;
        while (s.isEmpty()) {
            qTmp = s.pop();
            pTmp = s.pop();
            if (qTmp == null && pTmp == null) {
                continue;
            }
            if (qTmp == null || pTmp == null) {
                return false;
            }

            if (qTmp.val == pTmp.val) {
                s.push(qTmp.left);
                s.push(pTmp.right);
                s.push(qTmp.right);
                s.push(pTmp.left);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetricIteration(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);
        TreeNode pTmp;
        TreeNode qTmp;
        while (!s.isEmpty()) {
            qTmp = s.pop();
            pTmp = s.pop();
            if (qTmp == null && pTmp == null) {
                continue;
            }
            if (qTmp == null || pTmp == null) {
                return false;
            }

            if (qTmp.val == pTmp.val) {
                s.push(qTmp.left);
                s.push(pTmp.right);
                s.push(qTmp.right);
                s.push(pTmp.left);
            } else {
                return false;
            }
        }
        return true;
    }



    /*
    public static void main(String[] args) {
        //stack之中可以接受null
        //System.out.println(s.empty());
        //System.out.println(s.pop());
        //System.out.println(s.empty());
        //System.out.println(s.pop());
        //System.out.println(s.empty());
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = null;
        TreeNode five = new TreeNode(3);
        TreeNode six = null;
        TreeNode seven = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = null;
        two.right = five;
        three.left = null;
        three.right = seven;

        System.out.println(isSymmetric(one));




    }
    */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        String line = "[1,2,1]";
        boolean x = true;
        while (x) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new SymmetricTree().isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);
            x = false;
        }
    }
}