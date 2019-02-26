package leetcode.question2;

/**
 * Created by zunzunwang
 * Date: 2019-02-26
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 两个链表进行相加。 链表的每个节点代表一位数字。 链表头为个位， 以此类推十位百位。
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    /**
     * 这个方法改变了两个原始链条
     * 循环相加保存在原来的两个链中， 用一个boolean来记录是否要进位
     * 如果遇到两个链条同长度， 结束的时候判断创建新的节点。
     * 如果两个链条不同长度， 则对next非空的进行循环
     * 算法类似plusOne
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersStupid(ListNode l1, ListNode l2) {
        //init
        if(l1 == null || l2 == null){
            return null;
        }

        ListNode listheadL1 = l1;
        ListNode listheadL2 = l2;

        boolean plusOne = false;
        while(listheadL1 != null && listheadL2 != null){
            int valTmp = listheadL1.val + listheadL2.val;
            if(plusOne){
                valTmp++;
            }
            plusOne = valTmp / 10 > 0 ? true : false;
            int valNew = valTmp % 10;
            listheadL1.val = valNew;
            listheadL2.val = valNew;

            if(listheadL1.next == null && listheadL2.next == null) {
                if(plusOne){
                    ListNode tailNode = new ListNode(1);
                    listheadL2.next = tailNode;
                    return l2;
                } else {
                    return l2;
                }
            }
            listheadL1 = listheadL1.next;
            listheadL2 = listheadL2.next;
        }

        if(listheadL1 == null){
            //continue for listheadL2
            if(plusOne){
                while(listheadL2 != null){
                    if(listheadL2.val < 9){
                        listheadL2.val++;
                        return l2;
                    } else {
                        listheadL2.val = 0;
                        if(listheadL2.next == null){
                            ListNode tailNode = new ListNode(1);
                            listheadL2.next = tailNode;
                            return l2;
                        } else {
                            listheadL2 = listheadL2.next;
                        }
                    }
                }
            } else {
                return l2;
            }
        } else {
            //continue for listheadL1
            if(plusOne){
                while(listheadL1 != null){
                    if(listheadL1.val < 9){
                        listheadL1.val++;
                        return l1;
                    } else {
                        listheadL1.val = 0;
                        if(listheadL1.next == null){
                            ListNode tailNode = new ListNode(1);
                            listheadL1.next = tailNode;
                            return l1;
                        } else {
                            listheadL1 = listheadL1.next;
                        }
                    }
                }
            } else {
                return l1;
            }
        }
        return null;
    }

}
