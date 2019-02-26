package leetcode.question160;

/**
 * Created by zunzunwang
 * Date: 2019-02-25
 */

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * 找到两个单链表的相交点。
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class IntersectionofTwoLinkedLists {
    /**
     * 第一种思路建立两个指针 然后第一次循环计算出两者的长度差距n。
     * 之后再从头循环一次， 对长的链单独多循环n次让两者起始的长度保持一致， 直到循环到两个指向同一个object。
     * @param headA
     * @param headB
     * @return
     */
  /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //init
        if(headA == null || headB == null){
            return null;
        }

        int n = 0;
        ListNode headATmp = headA;
        ListNode headBTmp = headB;
        ListNode shortList = null;
        while(headATmp.next != null || headBTmp.next != null){
            if(headATmp.next != null){
                headATmp = headATmp.next;
            } else {
                n++;
                shortList = headA;
            }

            if(headBTmp.next != null){
                headBTmp = headBTmp.next;
            } else {
                n++;
                shortList = headB;
            }
        }

         if(headATmp != headBTmp){
             return null;
         }


        headATmp = headA;
        headBTmp = headB;

        if(shortList == null){
            shortList = headA;
        }

        if(shortList == headA){
            for (int i=0; i<n; i++){
                headBTmp = headBTmp.next;
            }
            while(shortList != headBTmp && headBTmp.next != null && shortList.next != null){
                shortList = shortList.next;
                headBTmp = headBTmp.next;
            }
            return shortList;
        } else {
            for (int i=0; i<n; i++){
                headATmp = headATmp.next;
            }


            while(shortList != headATmp && headATmp.next != null && shortList.next != null){
                shortList = shortList.next;
                headATmp = headATmp.next;
            }

            if(shortList == headATmp || shortList == headBTmp){
                return shortList;
            }
            return null;
        }
    }
    */

    /**
     * method2不直接计算两个链的差距。
     * 而是利用了一点两个链的长度和为固定的这个特性。
     * 分别对两个链进行循环。循环到末尾则对另一列进行循环。
     * 最终可以弥补到差距长度。 然后比较是否两者指向是否为同一个
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
