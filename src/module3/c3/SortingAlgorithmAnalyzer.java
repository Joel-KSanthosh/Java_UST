package module3.c3;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithmAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a sorting algorithm to analyze:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Enter the number of array sizes to test:");
            int numSizes = scanner.nextInt();
            System.out.println("Enter the starting size of arrays:");
            int startSize = scanner.nextInt();
            System.out.println("Enter the increment size:");
            int increment = scanner.nextInt();

            for (int i = 0; i < numSizes; i++) {
                int size = startSize + (i * increment);
                int[] arr = generateRandomArray(size);

                long startTime = System.nanoTime();

                switch (choice) {
                    case 1:
                        BubbleSort.bubbleSort(arr);
                        break;
                    case 2:
                        MergeSort.mergeSort(arr, 0, arr.length - 1);
                        break;
                    case 3:
                        QuickSort.quickSort(arr, 0, arr.length - 1);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Input size: " + size + ", Execution time: " + duration + " ns");
                // Uncomment below to print sorted array
                // printArray(arr);
            }
        }
        scanner.close();
    }

    // Method to generate random integer array
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // Method to print array (for verification)
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
