package leetcode.question141;

/**
 * Created by zunzunwang
 * Date: 2019-02-23
 */

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //init condition verification
        if(head == null){
            return false;
        }

        //Set the same start point.
        ListNode oneStep = head;
        if(head.next == null){
            return false;
        }

        ListNode twoStep = head.next;
        while(oneStep.next != null && twoStep.next != null && twoStep.next.next != null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if(oneStep == twoStep){
                return true;
            }
        }
        return false;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
