package swordoffer;

public class RebuildBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}

    /**
     *
     * @param pre 输入前序遍历结果
     * @param startPre 输入前序遍历的开始点
     * @param endPre 前序遍历的终结点
     * @param in 中序遍历结果
     * @param startIn 中序遍历的开始点
     * @param endIn 中序遍历的结束点
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        //首先判断运行的条件, 需要两个序列的首尾符合逻辑
        if (startPre > endPre || startIn > endIn)
            return null;

        //前序的第一个第一个一定是新的根结点。
        TreeNode root = new TreeNode(pre[startPre]);

        //从中序的第一个开始遍历, 找到根元素的所在位置。
        for (int i = startIn; i <= endIn; i++) {
            //找到了根元素
            if (in[i] == pre[startPre]) {
                //左子树的前序：[开始元素向后推一位, 开始元素向后推(i - startIn)位，计算出一共有多少元素]
                //左子树的中序：[还是原来的中序第一位, 第i位前一位是新的中序结尾]
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);

                //右子树的前序：[从startpre 向后推 i -  startIn +1位， endPre]
                //右子树的中序：[i + 1， endIn]
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);

                //停止循环
                break;
            }
        }

        return root;
    }


    public TreeNode recusiveRebuildTreeByPostandIn(int[] in, int[] post){
        TreeNode root = recusiveRebuildTreeByPostandIn(in, 0, in.length - 1, post, 0, post.length - 1);
        return root;
    }

    public TreeNode recusiveRebuildTreeByPostandIn(int[] in, int startIn, int endIn, int[] post, int startPost, int endPost){

        System.out.println(startIn + " " + endIn + " " + startPost + " " + endPost);
        if (startIn > endIn || startPost > endPost){
            return null;
        }

        TreeNode root = new TreeNode(post[endPost]);
        System.out.println(post[endPost]);

        for (int i = startIn; i <= endIn; i++){
            if (in[i] == post[endPost]){
                root.left = recusiveRebuildTreeByPostandIn(in, startIn, i - 1, post, startPost,i - 1);
                root.right= recusiveRebuildTreeByPostandIn(in,i + 1, endIn,post, i,endPost - 1);
                break;
            }
        }

        return root;
    }





    public static void main(String[] args) {
        //init
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        //create tree.
        one.left = two;
        one.right = three;
        two.left = four;
        four.right =seven;
        three.left = five;
        three.right = six;
        six.left = eight;

        System.out.println("\n--------------preTraversal---------------");
        TreeNode.preTraversal(one);

        System.out.println("\n--------------inTraversal----------------");
        TreeNode.inTraversal(one);

        System.out.println("\n--------------postTraversal--------------");
        TreeNode.postTraversal(one);



      RebuildBinaryTree rebuildBinaryTree =  new RebuildBinaryTree();
      int[] preArray = new int[]{1,2,4,7,3,5,6,8};
      int[] inArray = new int[]{4,7,2,1,5,3,8,6};
      int[] postArray = new int[]{7,4,2,5,8,6,3,1};

        System.out.println("\ngive pre and in, rebuild tree.");
        TreeNode root = rebuildBinaryTree.reConstructBinaryTree(preArray, inArray);
        System.out.println("\n--------------preTraversal---------------");
        TreeNode.preTraversal(root);

        System.out.println("\n--------------inTraversal----------------");
        TreeNode.inTraversal(root);

        System.out.println("\n--------------postTraversal--------------");
        TreeNode.postTraversal(root);

        System.out.println("\ngive in and post, rebuild tree.");
        TreeNode root2 = rebuildBinaryTree.recusiveRebuildTreeByPostandIn(inArray, postArray);
        System.out.println("\n--------------preTraversal---------------");
        TreeNode.preTraversal(root2);

        System.out.println("\n--------------inTraversal----------------");
        TreeNode.inTraversal(root2);

        System.out.println("\n--------------postTraversal--------------");
        TreeNode.postTraversal(root2);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    public static void preTraversal(TreeNode root) {
        if (root != null){
            System.out.print(root.val);
            preTraversal(root.left);
            preTraversal(root.right);
        }
    }

    public static void inTraversal(TreeNode root) {
        if (root != null){
            inTraversal(root.left);
            System.out.print(root.val);
            inTraversal(root.right);
        }
    }

    public static void postTraversal(TreeNode root) {
        if (root != null){
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.print(root.val);
        }
    }
}
