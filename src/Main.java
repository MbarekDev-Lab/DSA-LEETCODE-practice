import linkedList.DoublyLinkedList;
import linkedList.Node;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(1);

        myDLL.printList();
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        myDLL.append(2);

        System.out.println(myDLL.removeLast());
        System.out.println(myDLL.removeLast());
        System.out.println(myDLL.removeLast());

        myDLL.prepend(3);

        System.out.println(myDLL.removeFirst());

        myDLL.printList();

        myDLL.prepend(4);

        myDLL.set(0, 5);

        DoublyLinkedList.Node currentNode = myDLL.get(0);
        System.out.println("currentNode :  " + currentNode);


        boolean insertedCurrent = myDLL.insert(0, 5);
        System.out.println(" inserted Current :  " + insertedCurrent);

        DoublyLinkedList.Node removeCurrent = myDLL.remove(0);
        System.out.println(" removed Current :  " + removeCurrent);


    }
}
