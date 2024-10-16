package trees.binarysearch;

public class BinarySearchTree {
    
    private Node root;
    private int size = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        if (this.root == null) return true;
        return false;
    }

    public void insert(int key) {
        insertRecursive(this.root, key);
        size++;
    }

    private void insertRecursive(Node root, int key) {
        
    } 


}
