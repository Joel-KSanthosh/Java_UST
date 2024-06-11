package module3.c3;
import java.util.Random;

public class SortingTimeComplexityAnalysis {
    public static void main(String[] args) {
        // Define input sizes
        int[] inputSizes = {1000, 5000, 10000};

        // Measure and analyze Bubble Sort
        System.out.println("Bubble Sort:");
        measureAndAnalyzeBubbleSort(inputSizes);

        // Measure and analyze Merge Sort
        System.out.println("\nMerge Sort:");
        measureAndAnalyzeMergeSort(inputSizes);

        // Measure and analyze Quick Sort
        System.out.println("\nQuick Sort:");
        measureAndAnalyzeQuickSort(inputSizes);
    }

    // Method to measure and analyze Bubble Sort
    private static void measureAndAnalyzeBubbleSort(int[] inputSizes) {
        for (int size : inputSizes) {
            int[] arr = generateRandomArray(size);
            long startTime = System.nanoTime();
            BubbleSort.bubbleSort(arr);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + size + ", Time taken: " + elapsedTime + " ns");
        }
    }

    // Method to measure and analyze Merge Sort
    private static void measureAndAnalyzeMergeSort(int[] inputSizes) {
        for (int size : inputSizes) {
            int[] arr = generateRandomArray(size);
            long startTime = System.nanoTime();
            MergeSort.mergeSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + size + ", Time taken: " + elapsedTime + " ns");
        }
    }

    // Method to measure and analyze Quick Sort
    private static void measureAndAnalyzeQuickSort(int[] inputSizes) {
        for (int size : inputSizes) {
            int[] arr = generateRandomArray(size);
            long startTime = System.nanoTime();
            QuickSort.quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Input size: " + size + ", Time taken: " + elapsedTime + " ns");
        }
    }

    // Method to generate random integer arrays
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
