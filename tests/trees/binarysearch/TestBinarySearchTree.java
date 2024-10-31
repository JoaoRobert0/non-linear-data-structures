package tests.trees.binarysearch;

import trees.binarysearch.*;

public class TestBinarySearchTree {
    public static void main(String[] args) {

        BinarySearchTree bst1 = new BinarySearchTree();

        System.out.println(bst1.isEmpty()); // true

        bst1.insert(3);
        bst1.insert(1);
        bst1.insert(2);
        bst1.insert(7);
        bst1.insert(5);
        bst1.insert(6);

        bst1.displayPreOrder(); // OUT: 3 1 2 7 5 6 
        bst1.displayInOrder(); // OUT: 1 2 3 5 6 7 
        bst1.displayPostOrder(); // OUT: 2 1 6 5 7 3 

        System.out.println(bst1.isEmpty()); // false
        
        // ANOTHER TEST
        System.out.println(); // Break the line

        BinarySearchTree bst2 = new BinarySearchTree();

        bst2.insert(6);
        bst2.insert(2);
        bst2.insert(1);
        bst2.insert(4);
        bst2.insert(9);
        bst2.insert(8);

        bst2.displayPreOrder(); // OUT: 6 2 1 4 9 8 
        bst2.displayInOrder(); // OUT: 1 2 4 6 8 9 
        bst2.displayPostOrder(); // OUT: 1 4 2 8 9 6 

        bst2.insert(5);
        bst2.displayInOrder(); // OUT: 1 2 4 5 6 8 9 
        System.out.println(bst2.find(5)); // Node{key=5, father=4, leftChild=null, rightChild=null}

        System.out.println(bst2.find(4)); // Node{key=4, father=2, leftChild=null, rightChild=5}
        System.out.println(bst2.remove(5)); // true
        bst2.displayInOrder(); // OUT: 1 2 4 6 8 9 
        System.out.println(bst2.find(4)); // Node{key=4, father=2, leftChild=null, rightChild=null}

    }
}
