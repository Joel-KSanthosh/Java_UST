package module3.c2;
import java.util.Scanner;
public class LinkedListDemo {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at specific position");
            System.out.println("4. Delete a node");
            System.out.println("5. Search for a node");
            System.out.println("6. Display the list");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at the beginning: ");
                    int data1 = scanner.nextInt();
                    insertAtBeginning(data1);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at the end: ");
                    int data2 = scanner.nextInt();
                    insertAtEnd(data2);
                    break;
                case 3:
                    System.out.print("Enter the position to insert at: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter the element to insert: ");
                    int data3 = scanner.nextInt();
                    insertAtPosition(position, data3);
                    break;
                case 4:
                    System.out.print("Enter the element to delete: ");
                    int deleteData = scanner.nextInt();
                    deleteNode(deleteData);
                    break;
                case 5:
                    System.out.print("Enter the element to search: ");
                    int searchData = scanner.nextInt();
                    if (searchNode(searchData))
                        System.out.println("Node found in the list.");
                    else
                        System.out.println("Node not found in the list.");
                    break;
                case 6:
                    displayList();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
        scanner.close();
    }
    static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Element inserted at the beginning.");
    }
    static void insertAtEnd(int data) {
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
        System.out.println("Element inserted at the end.");
    }
    static void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Element inserted at position " + position + ".");
        }
    }
    static void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println("Element deleted.");
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element not found in the list.");
        } else {
            prev.next = current.next;
            System.out.println("Element deleted.");
        }
    }
    static boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    static void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
