import queue.Queue;
import stack.StackList;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(10);
        System.out.println("Initial queue:");
        myQueue.printQueue();

        // Enqueue values
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        System.out.println("\nAfter enqueuing 20 and 30:");
        myQueue.printQueue();

        // Peek at the first element
        System.out.println("\nPeek: " + myQueue.peek());

        // Dequeue a value
        Queue.Node removed = myQueue.dequeue();
        System.out.println("\nDequeued: " + removed.value);
        System.out.println("Queue after dequeue:");
        myQueue.printQueue();

        // Dequeue all to test empty state
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println("\nQueue after dequeuing all elements:");
        myQueue.printQueue();
        System.out.println("Is queue empty? " + myQueue.isEmpty());

        // Enqueue after emptying
        myQueue.enqueue(50);
        System.out.println("\nAfter enqueuing 50:");
        myQueue.printQueue();
        System.out.println("First: " + myQueue.getFirst().value + ", Last: " + myQueue.getLast().value);

        StackList<Object> myStack = new StackList<>();
        myStack.push("mbarek");
        myStack.push("20");
        myStack.push(30);

        System.out.println(myStack.pop());
        System.out.println(myStack.reverseString("Test 5: Spaces and Symbols"));
        myStack.printStack();

        System.out.println("Test 7: Nested Unbalanced");
        System.out.println("Input: '(()'");
        System.out.println("Expected: false");
        System.out.println("Actual: " + myStack.isBalancedParentheses("()())"));
        System.out.println();


        // Test 1: Empty stack
        System.out.println("Test 1: Empty Stack");
        StackList<Integer> stack = new StackList<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        myStack.sortStack(stack);
        System.out.println("Expected (top to bottom): empty");
        stack.printStack();
        System.out.println();


    }

}
