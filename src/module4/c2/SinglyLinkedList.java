package module4.c2;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private ListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to add a new node at the end of the list
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove a node with a specific value from the list
    public void remove(int val) {
        if (head == null) {
            return;
        }
        if (head.val == val) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Method to display the elements of the list
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display(); // Output: 1 2 3 4

        list.remove(3);
        list.display(); // Output: 1 2 4
    }
}
