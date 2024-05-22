package module3.c2;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayVsLinkedListPerformance {

    public static void main(String[] args) {
        int size = 100000; // Adjust the size of the collection as needed

        // Array Performance Test
        long arrayInsertionStartTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayInsertionEndTime = System.nanoTime();
        long arrayInsertionTime = arrayInsertionEndTime - arrayInsertionStartTime;

        long arrayDeletionStartTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.remove(0);
        }
        long arrayDeletionEndTime = System.nanoTime();
        long arrayDeletionTime = arrayDeletionEndTime - arrayDeletionStartTime;

        // LinkedList Performance Test
        long linkedListInsertionStartTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListInsertionEndTime = System.nanoTime();
        long linkedListInsertionTime = linkedListInsertionEndTime - linkedListInsertionStartTime;

        long linkedListDeletionStartTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.removeFirst();
        }
        long linkedListDeletionEndTime = System.nanoTime();
        long linkedListDeletionTime = linkedListDeletionEndTime - linkedListDeletionStartTime;

        // Output results
        System.out.println("Array Insertion Time: " + arrayInsertionTime + " ns");
        System.out.println("Array Deletion Time: " + arrayDeletionTime + " ns");
        System.out.println("LinkedList Insertion Time: " + linkedListInsertionTime + " ns");
        System.out.println("LinkedList Deletion Time: " + linkedListDeletionTime + " ns");

        // For searching, both ArrayList and LinkedList have O(n) time complexity
        // But ArrayList can perform better due to better cache locality
        // We'll perform a simple linear search for demonstration

        long arraySearchStartTime = System.nanoTime();
        arrayList.contains(size - 1);
        long arraySearchEndTime = System.nanoTime();
        long arraySearchTime = arraySearchEndTime - arraySearchStartTime;

        long linkedListSearchStartTime = System.nanoTime();
        linkedList.contains(size - 1);
        long linkedListSearchEndTime = System.nanoTime();
        long linkedListSearchTime = linkedListSearchEndTime - linkedListSearchStartTime;

        System.out.println("Array Search Time: " + arraySearchTime + " ns");
        System.out.println("LinkedList Search Time: " + linkedListSearchTime + " ns");
    }
}
