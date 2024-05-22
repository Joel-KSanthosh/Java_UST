package module3.c2;
import java.util.Scanner;
public class ArrayOperationsDemo {
    private static int[] array = new int[10]; // Initialize an array of size 10
    private static int size = 0; // Variable to keep track of the number of elements in the array
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Insert element");
            System.out.println("2. Delete element");
            System.out.println("3. Search element");
            System.out.println("4. Display array");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertElement(scanner);
                    break;
                case 2:
                    deleteElement(scanner);
                    break;
                case 3:
                    searchElement(scanner);
                    break;
                case 4:
                    displayArray();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
    private static void insertElement(Scanner scanner) {
        if (size == array.length) {
            System.out.println("Array is full. Cannot insert more elements.");
            return;
        }
        System.out.print("Enter the element to insert: ");
        int element = scanner.nextInt();
        array[size++] = element;
        System.out.println("Element inserted successfully.");
    }
    private static void deleteElement(Scanner scanner) {
        if (size == 0) {
            System.out.println("Array is empty. Cannot delete elements.");
            return;
        }
        System.out.print("Enter the element to delete: ");
        int element = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    private static void searchElement(Scanner scanner) {
        if (size == 0) {
            System.out.println("Array is empty. Cannot search elements.");
            return;
        }
        System.out.print("Enter the element to search: ");
        int element = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Element found in the array.");
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    private static void displayArray() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
