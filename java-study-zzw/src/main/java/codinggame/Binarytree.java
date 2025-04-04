package codinggame;

import codinggame.common.Node;

/**
 * Created by zunzunwang
 * Date: 13/03/2021
 */
public class Binarytree {


    /**
     *             9
     *        7        11
     *      5   8    10  12
     *    4   6
     */

    public static void main(String[] args) {
        Node node4 = new Node(null, null, 4);

        Node node6 = new Node(null, null, 6);
        Node node5 = new Node(node4, node6, 5);
        Node node8 = new Node(node6, null, 8);
        Node node7 = new Node(node5, node8, 7);
        Node node10 = new Node(null, null, 10);
        Node node12 = new Node(null, null, 12);
        Node node11 = new Node(node10, node12, 11);
        Node node9 = new Node(node7, node11, 9);
        System.out.println(node9.find(10).getValue());
        System.out.println(node9.findV2(4).getValue());

    }

}
