package module5;
import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {29, 7, 5, 10, -3, 22, 19, 12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        // Choose the median-of-three as the pivot
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(arr[low], arr[mid], arr[high]);
        // Rearrange elements around the pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static int medianOfThree(int a, int b, int c) {
        int[] temp = {a, b, c};
        Arrays.sort(temp);
        return temp[1]; // Middle element is the median
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
