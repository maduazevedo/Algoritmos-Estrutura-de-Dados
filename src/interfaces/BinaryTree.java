package interfaces;

import BinarySearchTree.BinarySearchTree;

public interface BinaryTree<T> extends Tree<T> {


    // Percurso em pré-ordem
    public void preOrderTraversal();
    // Percurso em-ordem
    public void inOrderTraversal();
    // Percurso em pós-ordem
    public void postOrderTraversal();
}