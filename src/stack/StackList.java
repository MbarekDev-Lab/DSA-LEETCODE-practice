package stack;

import java.util.ArrayList;

public class StackList<T> {

    private final ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.getLast();
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }


    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }


    public static String reverseString(String str) {
        StackList<Character> stack = new StackList<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static boolean isBalancedParentheses(String str) {
        StackList<Character> stack = new StackList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void sortStack(StackList<Integer> stack) {
        StackList<Integer> sorted = new StackList<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }

        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }

    public void enqueue(int value) {
        StackList<Integer> stack1 = new StackList<>();
        StackList<Integer> stack2 = new StackList<>();

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        StackList<Integer> stack1 = new StackList<>();
        if (isEmpty()) {
            return null;
        }
        return stack1.pop();
    }



}