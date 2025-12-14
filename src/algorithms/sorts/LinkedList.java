package algorithms.sorts;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(4);
        list.append(2);
        list.append(6);
        list.append(1);
        list.append(5);

        //list.bubbleSort();
        //list.selectionSort();
        list.insertionSort();

        list.printList();
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void bubbleSort() {

        if (length < 2) return;

        Node sortedUntil = null;

        while (sortedUntil != head.next) {

            Node current = head;

            while (current.next != sortedUntil) {

                if (current.value > current.next.value) {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }

                current = current.next;
            }

            sortedUntil = current;
        }
    }

    public void selectionSort() {

        if (length < 2) return;

        Node current = head;

        while (current.next != null) {

            Node smallest = current;
            Node innerCurrent = current.next;

            while (innerCurrent != null) {
                if (innerCurrent.value < smallest.value) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }

            if (smallest != current) {
                int temp = current.value;
                current.value = smallest.value;
                smallest.value = temp;
            }

            current = current.next;
        }

        tail = current;
    }

    public void insertionSort() {

        if (length < 2) return;

        Node sortedListHead = head;

        Node unsortedListHead = head.next;

        sortedListHead.next = null;

        while (unsortedListHead != null) {

            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;

                while (searchPointer.next != null &&
                        searchPointer.next.value < current.value) {
                    searchPointer = searchPointer.next;
                }

                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }


    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


}