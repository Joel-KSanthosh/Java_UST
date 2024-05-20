package module3.c1.queue;
import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {
    private Queue<String> queue;
    public TicketQueue() {
        // Use LinkedList as the underlying data structure for the queue
        this.queue = new LinkedList<>();
    }
    public void enqueue(String customer) {
        // Add a customer to the end of the queue
        queue.add(customer);
    }
    public String dequeue() {
        // Remove and return the customer at the front of the queue
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }
    public boolean isEmpty() {
        // Check if the queue is empty
        return queue.isEmpty();
    }
    public String peek() {
        // Return the customer at the front of the queue without removing them
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }
    public static void main(String[] args) {
        // Example usage:
        TicketQueue ticketQueue = new TicketQueue();
        // Customers arrive and are added to the queue
        ticketQueue.enqueue("Customer 1");
        ticketQueue.enqueue("Customer 2");
        ticketQueue.enqueue("Customer 3");
        // Serve customers in the order they arrived
        while (!ticketQueue.isEmpty()) {
            String currentCustomer = ticketQueue.dequeue();
            System.out.println("Processing " + currentCustomer);
        }
        // Output:
        // Processing Customer 1
        // Processing Customer 2
        // Processing Customer 3
    }
}
