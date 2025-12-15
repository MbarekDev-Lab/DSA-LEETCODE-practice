package algorithms.sorts;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                combined[k++] = arr1[i++];
            } else {
                combined[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[k++] = arr2[j++];
        }
        return combined;
    }

    public static int[] merge2(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[index++] = arr2[j++];
        }

        return combined;
    }


    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int midIndex = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }

    public static int[] mergeSort2(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int midIndex = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, midIndex);
        int[] right = Arrays.copyOfRange(array, midIndex, array.length);

        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);

        return merge(sortedLeft, sortedRight);
    }

    public static int[] merge3(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];

        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index++] = array1[i++];
            } else {
                combined[index++] = array2[j++];
            }
        }

        while (i < array1.length) {
            combined[index++] = array1[i++];
        }

        while (j < array2.length) {
            combined[index++] = array2[j++];
        }

        return combined;
    }

    public static int[] merge4(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            combined[k++] = (arr1[i] <= arr2[j]) ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) combined[k++] = arr1[i++];
        while (j < arr2.length) combined[k++] = arr2[j++];

        return combined;
    }


    // Time: O(n log n) vs Space: O(n)
    public static void main(String[] args) {
//        int[] array1 = {1, 3, 7, 8};
//        int[] array2 = {2, 4, 5, 6};
//
//        System.out.println(Arrays.toString(merge3(array1, array2)));


        int[] originalArray = {3, 1, 4, 2};

        int[] sortedArray = mergeSort2(originalArray);

        System.out.println("Original Array: " + Arrays.toString(originalArray));//Original Array: [3, 1, 4, 2]

        System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));//Sorted Array: [1, 2, 3, 4]


        //int[] arr1 = {1, 3, 4, 7, 8};
        //int[] arr2 = {2, 5, 4, 7, 5};

        //System.out.println(Arrays.toString(merge2(arr1, arr2))); //[1, 1, 3, 4, 3, 4, 7, 8, 7, 8]
        //System.out.println(Arrays.toString(merge(arr1, arr2)));  //[1, 2, 3, 4, 5, 4, 7, 7, 5, 8] Correct merge output

//        int[] originalArr = {3, 1, 4, 2};
//        int[] sortedArray = mergeSort(originalArr);
//
//        System.out.println("Original Arr :" + Arrays.toString(originalArr));
//        System.out.println("Original Arr :" + Arrays.toString(sortedArray));


    }
}
