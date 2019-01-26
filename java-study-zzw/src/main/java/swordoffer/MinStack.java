package swordoffer;

import java.util.Stack;

/**
 * creat your own stack object that can find the min value in the stack
 * with O(1);
 */

public class MinStack {
    Stack<Integer> lMain = new Stack<>();
    Stack<Integer> lSub = new Stack<>();

    public void push(int node) {
        if (lMain.empty()) {
           lSub.push(node);
        } else {
            if (node <= lSub.peek()) {
                lSub.push(node);
            }
        }
        lMain.push(node);
    }

    public void pop() {
        int res = lMain.pop();
        if (res == lSub.peek()){
            lSub.pop();
        }
    }

    public int top() {
        return lMain.peek();
    }

    public int min() {
        return lSub.peek();
    }
}

