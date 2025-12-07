package linkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        if (head == null) {
            System.out.println("Head: null");
            return null;
        }
        System.out.println("Head: " + head.value);
        return head;
    }

    public Node getTail() {
        if (tail == null) {
            System.out.println("Tail: null");
            return null;
        }
        System.out.println("Tail: " + tail.value);
        return tail;
    }

    public int getLength() {
        System.out.println("Length: " + length);
        return length;
    }

    public void printList() {
        Node temp = head;
        System.out.print("DLL: ");
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    // Get node at specific index
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node current;
        if (index < length / 2) {// start from head
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else { // start from tail
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Set node at specific index
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }


    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node before = get(index - 1);
        Node after = before.next;

        Node newNode = new Node(value);
        newNode.prev = before;
        newNode.next = after;

        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;
    }


    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node temp = get(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = null;
        temp.prev = null;

        length--;
        return temp;
    }


}