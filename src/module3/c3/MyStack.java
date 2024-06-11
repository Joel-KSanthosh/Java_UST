package module3.c3;

public class MyStack<T> {

    private T[] elements;
    private int top;

    public MyStack() {
        elements = (T[]) new Object[10]; // Initial capacity of 10
        top = -1;
    }

    public void push(T item) {
        if (isFull()) {
            // Handle overflow (optional: resize the array)
            throw new RuntimeException("Stack overflow");
        }
        elements[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return elements[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top + 1 == elements.length;
    }
}
