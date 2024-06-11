package module3.c3;

public class QueueMain {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Task 1");
        queue.enqueue("Task 2");

        System.out.println(queue.dequeue()); // Output: Task 1
        System.out.println(queue.isEmpty()); // Output: false

        queue.enqueue("Task 3");
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.isEmpty()); // Output: true

    }
}
