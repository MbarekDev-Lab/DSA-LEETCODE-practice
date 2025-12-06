import linkedList.LinkedList;
import linkedList.Node;

public class Main {


    public static void printItems(int a, int b) {
        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < a; j++) {
//                System.out.println("i = " + i + " j " + j + " ");
//            }
        }

        for (int k = 0; k < b; k++) {
            System.out.println("k = " + k);
        }
    }

    public static void main(String[] args) {
//        // printItems(10, 5);
//        LinkedList myLinkedList = new LinkedList(4);
//        myLinkedList.append(10);
//        myLinkedList.prepend(1);
//        myLinkedList.printList();
////        System.out.println("Head: " + myList.getHead());
////        System.out.println("Tail: " + myList.getTail());
////        System.out.println("Length: " + myList.getLength());
//        // Output:
////        1 -> 4 -> 10 -> null
////        Head: 1
////        Tail: 10
////        Length: 3
//
//        // Create nodes
//        Node head = new Node(11);
//        head.next = new Node(3);
//        head.next.next = new Node(23);
//        head.next.next.next = new Node(7);
//        Node tail = new Node(4);
//
//        head.next.next.next.next = tail;
//
//        // Print the list
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.value + " -> ");
//            current = current.next;
//        }
//        System.out.println("null");
//
//
//        Node removed = myLinkedList.removeLast();
//        if (removed != null) {
//            System.out.println("Removed: " + removed.value);
//        } else {
//            System.out.println("List was empty");
//        }
//
//        Node node = myLinkedList.get(2);
//        if (node != null) {
//            System.out.println(node.value);
//        } else {
//            System.out.println("Index does not exist");
//        }
//
//
//        myLinkedList.set(2, 99); // change value at index 2 to 99
//
//        System.out.println("After set: ");
//        myLinkedList.printList();


//        1 -> 4 -> 10 -> null
//        11 -> 3 -> 23 -> 7 -> 4 -> null
//        Removed: 10

//        head = {
//                "value" = 11,
//                "next" = {
//                        "value" = 3,
//                        "next" = {
//                                "value" = 23,
//                                "next" = {
//                                        "value" = 7,
//                                        "next" = {
//                                                "value" = 4,
//                                                "next" = null
//                                        }
//                                }
//                        }
//                }
//        }

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(10);
        myLinkedList.prepend(1);

        myLinkedList.printList();   // 1 → 4 → 10

        Node removed = myLinkedList.removeLast();
        System.out.println("Removed: " + removed.value);  // 10

        Node n = myLinkedList.get(1);   // valid
        if (n != null) {
            System.out.println("Value at index 1: " + n.value);
        }

        if (myLinkedList.set(1, 99)) {
            System.out.println("Set success!");
        } else {
            System.out.println("Set failed!");
        }

        myLinkedList.printList();   // 1 → 99

        System.out.println("\n--- Testing Insert() ---");

        // Insert at index 1 (middle)
        myLinkedList.insert(1, 55);
        myLinkedList.printList();   // 1 → 55 → 99

        // Insert at index 0 (prepend)
        myLinkedList.insert(0, 111);
        myLinkedList.printList();   // 111 → 1 → 55 → 99

        // Insert at tail (append)
        myLinkedList.insert(myLinkedList.getLength(), 222);
        myLinkedList.printList();   // 111 → 1 → 55 → 99 → 222

        // Invalid index
        boolean ok = myLinkedList.insert(99, 123);
        System.out.println("Insert at invalid index: " + ok);

        Node removedNode = myLinkedList.remove(1);
        if (removedNode != null) {
            System.out.println("Removed Node at index 1: " + removedNode.value);
        } else {
            System.out.println("No node removed at index 1 (invalid index).");
        }

        System.out.println("Original List:");
        myLinkedList.printList();

        myLinkedList.reverse();
        System.out.println("Reversed List:");
        myLinkedList.printList();

        Node middleNode = myLinkedList.findMiddleNode();
        System.out.println(middleNode.value); //55

    }
}