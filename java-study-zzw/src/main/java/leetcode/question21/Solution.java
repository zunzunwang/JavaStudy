package leetcode.question21;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //First method
        ListNode start;
        ListNode end;
        ListNode p1;
        ListNode p2;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        //first init
        if (l1.val < l2.val) {
            start = l1;
            end = l1;
            p1 = l1.next;
            p2 = l2;
        } else {
            start = l2;
            end = l2;
            p1 = l1;
            p2 = l2.next;
        }

        while (!(p1 == null && p2 == null)) {
            if (p1 == null && p2 != null) {
                end.next = p2;
                break;
            }

            if (p2 == null && p1 != null) {
                end.next = p1;
                break;
            }

            if (p1.val > p2.val) {
                end.next = p2;
                end = end.next;
                p2 = p2.next;
            } else {
                end.next = p1;
                end = end.next;
                p1 = p1.next;
            }
        }
        return start;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
