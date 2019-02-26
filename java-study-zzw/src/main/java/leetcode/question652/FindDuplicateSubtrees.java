package leetcode.question652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 找到一个二叉树中所有的重复的子树结构
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Map<String, Integer> map = new HashMap<>();
        String serial = preOrderSerialisation(root, resultList, map);
        return resultList;
    }

    public String preOrderSerialisation(TreeNode root, List<TreeNode> resultList, Map<String, Integer> map) {
        if (root == null) {
            //为了避免会遇到val=0的情况所以需要避免使用0.
            return "#";
        }

        String serial = root.val + "."
                + preOrderSerialisation(root.left, resultList, map) + "."
                + preOrderSerialisation(root.right, resultList, map);

        if (map.containsKey(serial)) {
            if (!(map.get(serial) > 1)) {
                resultList.add(root);
                map.put(serial, map.get(serial) + 1);
            } else {
                map.put(serial, map.get(serial) + 1);
            }
        } else {
            map.put(serial, 1);
        }

        return serial;
    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //map.put("hello", null);
        System.out.println(map.containsKey("hello"));
        System.out.println(map.getOrDefault("hello", "bonjour"));
        System.out.println(map.size());
    }
}
