package codinggame;

import java.util.EmptyStackException;

public class Stack {
    // keep these two fields as they are
    private Object[] elements;
    private int size = 0;

    public Stack(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public void push(Object object) {
        ensureCapacity();
        elements[size++] = object;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        /**
         * 加入这一行
         */
        reduceCapacity();

        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] old = elements;
            elements = new Object[2 * size + 1];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }

    /**
     * 加入这函数
     */
    private void reduceCapacity() {
        if (elements.length > size * 2) {
            Object[] old = elements;
            elements = new Object[size];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }
}
