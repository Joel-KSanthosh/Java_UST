package module3.c6;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Add a new node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add a new node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert a new node at a specified position in the list
    public void insertAt(int data, int position) {
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a node with a given value from the list
    public void delete(int data) {
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node with given value not found.");
            return;
        }
        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }
    }

    // Display all the elements in the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Demonstrate functionality
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.display(); // Output: 5 10 20
        list.insertAt(15, 2);
        list.display(); // Output: 5 10 15 20
        list.delete(10);
        list.display(); // Output: 5 15 20
    }
}
