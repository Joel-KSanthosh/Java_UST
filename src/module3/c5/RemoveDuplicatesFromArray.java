package module3.c5;
import java.util.*;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();

        // Add elements to the HashSet to remove duplicates
        for (int num : nums) {
            uniqueSet.add(num);
        }

        // Create a new array to store unique elements
        int[] uniqueArray = new int[uniqueSet.size()];

        // Copy unique elements from HashSet to the new array
        int index = 0;
        for (int num : uniqueSet) {
            uniqueArray[index++] = num;
        }

        return uniqueArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 1, 5};
        int[] uniqueArray = removeDuplicates(nums);
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));
    }
}
