package binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(50);

        // Insert nodes
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("BFS Traversal: " + bst.BFS());
        System.out.println("DFS PreOrder: " + bst.DFSPreOrder());
        System.out.println("DFS InOrder: " + bst.DFSInOrder());
        System.out.println("DFS PostOrder: " + bst.DFSPostOrder());

        System.out.println("Contains 40? " + bst.contains(40));
        System.out.println("Contains 100? " + bst.contains(100));

        System.out.println("Is valid BST? " + bst.isValidBST());

        System.out.println("Removing 20...");
        bst.remove(20);
        System.out.println("BFS after removal: " + bst.BFS());

        System.out.println("Removing 30...");
        bst.remove(30);
        System.out.println("BFS after removal: " + bst.BFS());

        System.out.println("Removing 50 (root)...");
        bst.remove(50);
        System.out.println("BFS after removal: " + bst.BFS());
    }
}