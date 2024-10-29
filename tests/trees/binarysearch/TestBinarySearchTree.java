package tests.trees.binarysearch;

import trees.binarysearch.*;

public class TestBinarySearchTree {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println(bst.isEmpty()); // True

        bst.insert(2);
        bst.insert(1);
        bst.insert(9);
        bst.insert(3);
        bst.insert(5);
        bst.insert(8);
        bst.insert(7);

        System.out.println(bst.isEmpty()); // False

        bst.displayPreOrder();
        bst.displayInOrder();
        bst.displayPostOrder();

    }
}
