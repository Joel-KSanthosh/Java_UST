package module3.c3;

import java.util.*;

public class ArrayPairSum {
    public static List<int[]> findPairs(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Populate index map
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                int[] pair = {indexMap.get(complement), i};
                pairs.add(pair);
            }
            indexMap.put(nums[i], i);
        }

        return pairs;
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 8, 11, 7};
        int target = 10;

        List<int[]> pairs = findPairs(nums, target);
        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            System.out.println("Pairs that sum up to " + target + ":");
            for (int[] pair : pairs) {
                System.out.println("(" + nums[pair[0]] + ", " + nums[pair[1]] + ")");
            }
        }
    }
}

