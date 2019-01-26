package swordoffer;

import java.util.Stack;

public class CheckStackPopPossibility {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 ||  popA.length == 0)
            return false;

        Stack<Integer> tmp = new Stack();

        int popIndex = 0;
        for(int i = 0; i < pushA.length; i++) {
            //这里每次先入栈
            tmp.push(pushA[i]);

            //检查是否出栈， 如果相同则出栈。如果不相同则入栈。
            while (!tmp.empty() && tmp.peek() == popA[popIndex]) {
                popIndex++;
                tmp.pop();
            }
        }

        //如果最后没有全部出栈则视为false;
        return tmp.empty();
    }

    public static void main(String[] args){
        CheckStackPopPossibility c = new CheckStackPopPossibility();
        int[] i1 = new int[]{1,2,3,4,5};
        int[] i2 = new int[]{4,3,2,1,5};
        System.out.println(c.IsPopOrder(i1, i2));
    }
}
