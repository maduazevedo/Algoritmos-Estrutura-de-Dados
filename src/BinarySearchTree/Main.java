package BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(25);
        tree.add(21);

        tree.postOrderTraversal();
    }
}
