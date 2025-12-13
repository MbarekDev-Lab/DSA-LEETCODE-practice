package hashtables;


import java.util.*;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" { " + temp.key + " = " + temp.value + " } ");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void set2(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            if (Objects.equals(temp.key, key)) {
                temp.value += value;
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
                if (Objects.equals(temp.key, key)) {
                    temp.value += value;
                    return;
                }
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null) {
            //if (temp.key == key) return temp.value;
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    //This is O(n × m) (nested loops).
    public static boolean itemInCommon(int[] arr1, int[] arr2) {
        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) return true;
            }
        }
        return false;
    }

    // This is O(n + m) (fast)
    public static boolean itemInCommonHT(int[] arr1, int[] arr2) {
        Map<Integer, Boolean> ht = new HashMap<>();


        for (int i : arr1) {
            ht.put(i, true);
        }

        for (int j : arr2) {
            if (ht.get(j) != null) return true;
        }

        return false;
    }


    //HT: Find Duplicates ( O(n) time, O(n) space) :
    public static List<Integer> findDuplicates(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                duplicates.add(key);
            }
        }

        return duplicates;
    }

    //Time complexity is O(n), space complexity O(1)
    public static Character firstNonRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return null;
    }


    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> result = new ArrayList<>();

        if (strings == null || strings.length == 0) return result;

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strings) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add the word into the correct group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        result.addAll(map.values());

        return result;
    }

    // Time: O(n),    O(n) space.
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }


    //O(n) time,
    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target) + 1;
                int end = i;
                return new int[]{start, end};
            }

            map.putIfAbsent(prefixSum, i);
        }
        return new int[]{};
    }

    //O(n) time.
    public static int[] removeDuplicates(List<Integer> myList) {
        Set<Integer> set = new HashSet<>(myList);
        return new int[0];
    }

    public static List<Integer> removeDuplicatesLinkedHashSet(List<Integer> myList) {
        Set<Integer> set = new LinkedHashSet<>(myList);
        return new ArrayList<>(set);
    }

    // O(n)
    public static boolean hasUniqueChars(String string) {
        Set<Character> seen = new HashSet<>();

        for (char c : string.toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }

        return true;
    }

    //  O(1)
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            int complement = target - num;
            if (set.contains(complement)) {
                result.add(new int[]{complement, num});
            }
        }
        return result;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


}
