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
    }
}
