package leetcode.question82;

/**
 * 删除已排序的链表里的所有重复的元素。 使得出现的元素都是只出现过一次的。
 */
public class DeleteDuplicatsFromSortedList {

    //这个方法只能保存出现一次的元素 彻底删除重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nodeStart = head;
        ListNode nodeEnd = head;
        boolean isDouble = false;
        boolean isFirst = true;

        while (nodeStart != null && nodeStart.next != null) {
            nodeStart = nodeStart.next;
            if (nodeEnd.val != nodeStart.val) {
                if (nodeStart.next == null) {
                    if (!isDouble) {
                        nodeEnd.next = nodeStart;
                    }
                    return head;
                }

                if (nodeStart.next != null && nodeStart.next.val != nodeStart.val) {
                    if (!isDouble) {
                        nodeEnd.next = nodeStart;
                        if (isFirst) {
                            head = nodeEnd;
                            isFirst = false;
                        }
                        nodeEnd = nodeStart;
                    }
                    isDouble = false;
                } else {
                    isDouble = true;
                    nodeEnd.next = null;
                }
            } else {
                if (nodeStart.next == null)
                    return null;
                while (nodeStart.next != null && nodeEnd.val == nodeStart.next.val) {
                    nodeStart = nodeStart.next;
                }
                head = nodeStart.next;
                nodeEnd = nodeStart.next;
                nodeStart = nodeStart.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode headNext = head.next;
        int val = head.val;

        if (headNext.val != val){
            head.next = deleteDuplicatesRecursive(head.next);
            return head;
        } else {
            while(headNext != null && val == headNext.val){
                headNext = headNext.next;
            }
            return deleteDuplicatesRecursive(headNext);
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
