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


    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node left = head;
        Node right = tail;

        while (left != right && left.prev != right) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
    }


    public void reverse() {
        if (length <= 1) {
            return;
        }

        Node current = head;
        Node temp = null;

        // Swap next and prev pointers for every node
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // moving "forward" using swapped links
        }

        // After swapping everything, temp is at the old head
        // So tail becomes head, and head becomes tail
        temp = head;
        head = tail;
        tail = temp;
    }


    public void partitionList(int x) {
        if (head == null || head.next == null) return;

        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        Node lessTail = lessHead;
        Node greaterTail = greaterHead;

        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.prev = current.next = null;

            if (current.value < x) {
                lessTail.next = current;
                current.prev = lessTail;
                lessTail = current;
            } else {
                greaterTail.next = current;
                current.prev = greaterTail;
                greaterTail = current;
            }

            current = nextNode;
        }

        // Stitch lists together
        if (lessHead.next == null) {
            // No < x nodes → greater list stays as is
            head = greaterHead.next;
            if (head != null) head.prev = null;
            return;
        }

        // Connect less + greater
        lessTail.next = greaterHead.next;

        if (greaterHead.next != null) {
            greaterHead.next.prev = lessTail;
        }

        // New head
        head = lessHead.next;
        head.prev = null;
    }


    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) return;

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;
        // 1. Move prev to the node right before startIndex
        for (int i = 0; i < startIndex; i++) {
            if (prev.next == null) return; // startIndex out of bounds
            prev = prev.next;
        }

        // current is the first node in the segment to reverse
        Node current = prev.next;

        // 2. Reverse nodes in-place by removing the next node and inserting it after prev
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = current.next;

            // detach nodeToMove
            current.next = nodeToMove.next;
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = current;
            }

            // move nodeToMove to the front of the sublist
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        // Reset head
        head = dummy.next;
        head.prev = null;
    }



    public void swapPairs() {
        if (head == null || head.next == null) return;

        Node current = head;

        // The second node will become the new head
        head = head.next;

        while (current != null && current.next != null) {

            Node first  = current;
            Node second = current.next;
            Node prev   = first.prev;
            Node next   = second.next;

            // Link second -> first
            second.prev = prev;
            second.next = first;

            first.prev = second;
            first.next = next;

            // Fix prev.next if exists
            if (prev != null) prev.next = second;

            // Fix next.prev if exists
            if (next != null) next.prev = first;

            // Move forward two nodes
            current = next;
        }
    }



}