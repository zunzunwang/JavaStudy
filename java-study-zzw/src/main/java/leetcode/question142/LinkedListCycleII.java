package leetcode.question142;

/**
 * Created by zunzunwang
 * Date: 2019-02-25
 */

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * 判断链表里是否含有环， 并且找到该环中的接入点。
 */

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        //init condition.
        if (head == null) {
            return null;
        }

        ListNode oneStep = head;
        ListNode twoStep = head;

        while (oneStep.next != null && twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                //reset twoStep to head and run as one step.
                twoStep = head;
                while (oneStep != twoStep) {
                    oneStep = oneStep.next;
                    twoStep = twoStep.next;
                }
                return oneStep;
            }
        }
        return null;
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
