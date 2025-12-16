package algorithms.factorial;

import java.util.Arrays;

public class Main {

    public static int removeElement(int[] nums, int val) {
        int writeIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    public static int[] findMaxMin(int[] myList) {
        int max = myList[0];
        int min = myList[0];

        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
            if (myList[i] < min) {
                min = myList[i];
            }
        }
        return new int[]{max, min};
    }

    public static String findLongestString(String[] stringList) {
        if (stringList == null || stringList.length == 0) {
            return "";
        }
        String longest = stringList[0];

        for (int i = 1; i < stringList.length; i++) {
            if (stringList[i].length() > longest.length()) {
                longest = stringList[i];
            }
        }
        return longest;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }


    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static int maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
//        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int val1 = 1;
//        int newLength1 = removeElement(nums1, val1);
//        System.out.println("Test case : Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
//                "\nNew length: " + newLength1);

//        int[] myList4 = {100, 200, 300, 400, 500};
//        int[] result4 = findMaxMin(myList4);
//        System.out.println("Test case : MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"

//        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
//        String longest1 = findLongestString(stringList1);
//        System.out.println("Test case : Longest string: " + longest1);  // prints "banana"

//        int[] prices1 = {7, 1, 5, 3, 6, 4};
//        int profit1 = maxProfit(prices1);
//        System.out.println("Test case : Maximum profit: " + profit1); // prints "Maximum profit: 5"

//        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
//        int k1 = 3;
//        rotate(nums1, k1);
//        System.out.println(" Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);//Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4] .-> Result: 6


    }

}
