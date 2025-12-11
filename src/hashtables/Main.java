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
    }
}
