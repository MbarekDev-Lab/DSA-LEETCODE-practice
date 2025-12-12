package hashtables;

public class Main {
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


    }
}
