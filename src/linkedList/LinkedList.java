package linkedList;

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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getLength() {
        return length;
    }

    public int getHead() {
        return head != null ? head.value : -1;
    }

    public int getTail() {
        return tail != null ? tail.value : -1;
    }

    // --------------------
    //      APPEND
    // --------------------
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

    // --------------------
    //      PREPEND O(1)
    // --------------------
    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // --------------------
    //      REMOVE LAST
    // --------------------
    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        // Edge case: list becomes empty
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;  // the removed node
    }

    // --------------------
    //      REMOVE FIRST O(1)
    // --------------------
    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;             // return the removed node
    }

    // --------------------
    //      GET O(1)
    // --------------------
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;  // return the node at 'index'
    }

    // --------------------
    //      SET O(1)
    // --------------------
    public boolean set(int index, int value) {
        Node node = get(index); // reuse get() method
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }


    // --------------------
    //      Insert O(1)
    // --------------------

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

        Node newNode = new Node(value);
        Node tempNode = get(index - 1);

        newNode.next = tempNode.next;
        tempNode.next = newNode;

        length++;
        return true;
    }

    // --------------------
    //      Remove O(1)
    // --------------------

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node removed = prev.next;

        prev.next = removed.next;
        removed.next = null;

        length--;
        return removed;

    }


    // --------------------
    //      Reverse O(1)
    // --------------------
    public void reverse() {

        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node befor = null;

        for (int i = 0; i < length; i++) {

            after = temp.next;
            temp.next = befor;
            befor = temp;
            temp = after;

        }


    }


}
