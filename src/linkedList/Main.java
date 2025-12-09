package linkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== BASIC OPERATIONS ===");

        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.printList();       // 1
        myDLL.getHead();         // 1
        myDLL.getTail();         // 1
        myDLL.getLength();       // 1

        myDLL.append(2);         // DLL: 1 <-> 2
        myDLL.append(3);         // DLL: 1 <-> 2 <-> 3
        myDLL.printList();

        System.out.println("removeLast: " + myDLL.removeLast());
        System.out.println("removeLast: " + myDLL.removeLast());
        System.out.println("removeLast: " + myDLL.removeLast());
        myDLL.printList();

        myDLL.prepend(3);        // DLL: 3
        System.out.println("removeFirst: " + myDLL.removeFirst());
        myDLL.printList();

        myDLL.prepend(4);        // DLL: 4
        myDLL.set(0, 5);
        System.out.println("Node at index 0: " + myDLL.get(0));

        boolean inserted = myDLL.insert(0, 5);
        System.out.println("Inserted at index 0: " + inserted);

        System.out.println("Removed index 0: " + myDLL.remove(0));

        System.out.println("\n=== PALINDROME ===");
        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(2);
        dll.append(1);

        dll.printList();
        System.out.println("Is palindrome? " + dll.isPalindrome());

        System.out.println("\n=== REVERSE ===");
        dll.reverse();
        dll.printList();

        System.out.println("\n=== PARTITION LIST (x = 5) ===");

        DoublyLinkedList p = new DoublyLinkedList(3);
        p.append(8);
        p.append(5);
        p.append(10);
        p.append(2);
        p.append(1);

        p.printList();
        p.partitionList(5);
        p.printList();

        System.out.println("\n=== REVERSE BETWEEN (1, 3) ===");

        DoublyLinkedList r = new DoublyLinkedList(1);
        r.append(2);
        r.append(3);
        r.append(4);
        r.append(5);

        r.printList();         // 1 <-> 2 <-> 3 <-> 4 <-> 5
        r.reverseBetween(1, 3);
        r.printList();         // 1 <-> 4 <-> 3 <-> 2 <-> 5

        System.out.println("\n=== SWAP PAIRS ===");

        DoublyLinkedList s = new DoublyLinkedList(1);
        s.append(2);
        s.append(3);
        s.append(4);
        s.append(5);

        s.printList();         // 1 <-> 2 <-> 3 <-> 4 <-> 5
        s.swapPairs();
        s.printList();         // 2 <-> 1 <-> 4 <-> 3 <-> 5

        /**
         * Output:
         * === BASIC OPERATIONS ===
         * DLL: 1
         * Head: 1
         * Tail: 1
         * Length: 1
         * DLL: 1 <-> 2 <-> 3
         * removeLast: 3
         * removeLast: 2
         * removeLast: 1
         * DLL:
         * removeFirst: 3
         * DLL:
         * Node at index 0: 5
         * Inserted at index 0: true
         * Removed index 0: 5
         *
         * === PALINDROME ===
         * DLL: 1 <-> 2 <-> 3 <-> 2 <-> 1
         * Is palindrome? true
         *
         * === REVERSE ===
         * DLL: 1 <-> 2 <-> 3 <-> 2 <-> 1
         *
         * === PARTITION LIST (x = 5) ===
         * DLL: 3 <-> 8 <-> 5 <-> 10 <-> 2 <-> 1
         * DLL: 3 <-> 2 <-> 1 <-> 8 <-> 5 <-> 10
         *
         * === REVERSE BETWEEN (1, 3) ===
         * DLL: 1 <-> 2 <-> 3 <-> 4 <-> 5
         * DLL: 1 <-> 4 <-> 3 <-> 2 <-> 5
         *
         * === SWAP PAIRS ===
         * DLL: 1 <-> 2 <-> 3 <-> 4 <-> 5
         * DLL: 2 <-> 1 <-> 4 <-> 3 <-> 5
         */

    }


}
