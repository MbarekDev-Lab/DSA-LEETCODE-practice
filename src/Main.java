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
        // printItems(10, 5);

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(10);
        myLinkedList.prepend(1);
        myLinkedList.printList();
//        System.out.println("Head: " + myList.getHead());
//        System.out.println("Tail: " + myList.getTail());
//        System.out.println("Length: " + myList.getLength());
        // Output:
//        1 -> 4 -> 10 -> null
//        Head: 1
//        Tail: 10
//        Length: 3


        // Create nodes
        Node head = new Node(11);
        head.next = new Node(3);
        head.next.next = new Node(23);
        head.next.next.next = new Node(7);
        Node tail = new Node(4);

        head.next.next.next.next = tail;

        // Print the list
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");


        Node removed = myLinkedList.removeLast();
        if (removed != null) {
            System.out.println("Removed: " + removed.value);
        } else {
            System.out.println("List was empty");
        }

        System.out.println(myLinkedList.get(2).value);

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
    }
}