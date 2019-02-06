package swordoffer;

import java.util.ArrayList;
import java.util.Stack;

public class ReadFromEndLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<>();
        }

        ArrayList res = new ArrayList<>();
        Stack<Integer> s = new Stack();
        s.push(listNode.val);
        while (listNode.next != null){
            listNode = listNode.next;
            s.push(listNode.val);
        }

        while (!s.isEmpty()){
            res.add(s.pop());
        }

        return res;

    }

    public ArrayList<Integer> printListFromTailToHeadRecursive(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<>();
        }
        ArrayList res = new ArrayList<>();
        getListNodeVal(listNode, res);
        return res;
    }

    public static void getListNodeVal(ListNode listNode, ArrayList res) {
        if (listNode != null){
            if (listNode.next != null){
                getListNodeVal(listNode.next, res);
            }
            res.add(listNode.val);
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
