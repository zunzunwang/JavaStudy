package leetcode.question83;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除已排序的链表中的重复元素。 使得每个元素都只出现一次。
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        Map<Integer, Integer> map = new HashMap<>();
        ListNode nodeStart = head;
        ListNode nodeEnd = head;
        //init
        map.put(head.val, 1);

        while(nodeStart.next != null){
            nodeStart = nodeStart.next;
            if (!map.containsKey(nodeStart.val)){
                map.put(nodeStart.val, 1);
                nodeEnd.next = nodeStart;
                nodeEnd = nodeStart;
            }
        }
        nodeEnd.next = null;
        return head;
    }

    public ListNode deleteDuplicatesOptimise(ListNode head) {
        //利用是有序的特性 节省了空间。
        if (head == null || head.next == null)
            return head;

        ListNode nodeStart = head;
        ListNode nodeEnd = head;

        while(nodeStart.next != null){
            nodeStart = nodeStart.next;
            if (nodeStart.val != nodeEnd.val){
                nodeEnd.next = nodeStart;
                nodeEnd = nodeStart;
            }
        }
        nodeEnd.next = null;
        return head;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
