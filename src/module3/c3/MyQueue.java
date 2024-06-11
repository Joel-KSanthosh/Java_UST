package module3.c3;

public class MyQueue<T> {

    private T[] elements;
    private int front, rear;

    public MyQueue() {
        elements = (T[]) new Object[10]; // Initial capacity of 10
        front = -1;
        rear = -1;
    }

    public void enqueue(T item) {
        if (isFull()) {
            // Handle overflow (optional: resize the array)
            throw new RuntimeException("Queue overflow");
        }
        if (isEmpty()) {
            front = 0;
        }
        elements[++rear] = item;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T temp = elements[front];
        if (front == rear) {
            front = rear = -1; // Reset for single element case
        } else {
            front++;
        }
        return temp;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return (rear + 1) % elements.length == front; // Handle wrap-around
    }
}

