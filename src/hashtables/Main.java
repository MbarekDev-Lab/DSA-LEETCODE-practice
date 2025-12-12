package hashtables;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static String formatResult(int[] result) {
        return result.length == 0 ? "[]" : Arrays.toString(result);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("nails", 100);
        hashTable.set("title", 50);
        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);

        hashTable.printTable();

        System.out.println("get nails -> " + hashTable.get("nails"));

        System.out.println("get keys  -> " + hashTable.keys());

        System.out.println(hashTable.itemInCommon(new int[]{1, 3, 5}, new int[]{2, 4, 5}));
        System.out.println(hashTable.itemInCommonHT(new int[]{1, 3, 5}, new int[]{2, 4, 5}));


        // Test 3: Multiple duplicates
        System.out.println("Test 3: Multiple Duplicates");
        int[] nums3 = {1, 2, 2, 3, 3, 4};
        System.out.println("Expected: [2, 3] (order may vary)");
        System.out.println("Actual: " + hashTable.findDuplicates(nums3));
        System.out.println();


        // Test : First unique character exists
        System.out.println("Test 1: First Unique Exists");
        String input1 = "swiss";
        System.out.println("Expected: w");
        System.out.println("Actual: " + hashTable.firstNonRepeatingChar(input1));
        System.out.println();

        // Test 2: Words with no anagrams
        System.out.println("Test 2: Single Words Remain");
        String[] input2 = {"dog", "cat"};
        System.out.println("Expected: [[dog], [cat]] (order may vary)");//Expected: [[dog], [cat]] (order may vary)
        System.out.println("Actual: " + hashTable.groupAnagrams(input2)); //Actual: [[cat], [dog]]
        System.out.println();

        // Test : Basic subarray
        System.out.println("Test 1: Basic Subarray");
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        System.out.println("Expected: Indices of subarray summing to 9");
        System.out.println("Actual: " + formatResult(hashTable.subarraySum(nums1, target1)));
        System.out.println();

        // Test 1: Duplicates removed
        System.out.println("Test 1: Duplicates Removed");
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 3, 4);
        System.out.println("Expected: [1, 2, 3, 4]");
        System.out.println("Actual: " + formatResult(hashTable.removeDuplicates(list1)));
        System.out.println();


    }
}
