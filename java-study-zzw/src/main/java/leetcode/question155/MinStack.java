package leetcode.question155;

import java.util.Stack;

/**
 * Created by zunzunwang
 * Date: 2019-02-25
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

class MinStack {
    private Stack<Integer> stackStorage;
    private Stack<Integer> stackHelpHolder;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackStorage = new Stack();
        stackHelpHolder = new Stack();
    }

    public void push(int x) {
        stackStorage.push(x);
        if (stackHelpHolder.isEmpty()) {
            stackHelpHolder.push(x);
        } else {
            if (x <= stackHelpHolder.peek()) {
                stackHelpHolder.push(x);
            }
        }
    }

    public void pop() {
        if (!(stackStorage.isEmpty() && stackHelpHolder.isEmpty())) {
            if (stackStorage.peek().equals(stackHelpHolder.peek())) {
                stackStorage.pop();
                //only when the value is equal. we will pop the value of help holder.
                stackHelpHolder.pop();
            } else {
                stackStorage.pop();
            }
        }
    }

    public int top() {
        return stackStorage.peek();
    }

    public int getMin() {
        return stackHelpHolder.peek();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.getMin());

    }
}
