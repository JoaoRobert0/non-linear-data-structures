package trees.binarysearch;

public class BinarySearchTree {
    
    private Node root;
    private int size;

    // Initialize the BST
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
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
        if (isEmpty()) {
            Node node = new Node(key);
            this.root = node;
        } else if (key <= root.getKey()) {
            if (root.getLeftChild() == null) {
                Node node = new Node(key);
                node.setFather(root);
                root.setLeftChild(node);
            } else {
                // Call the function recursive to the left side
                insertRecursive(root.getLeftChild(), key);
            }
        } else if (key > root.getKey()) {
            if (root.getRightChild() == null) {
                Node node = new Node(key);
                node.setFather(root);
                root.setRightChild(node);
            } else {
                // Call the function recursive to the right side
                insertRecursive(root.getRightChild(), key);
            }
        }

    } 

    public void displayPreOrder() {
        int[] result = new int[size];
        preOrderRec(this.root, result, 0);
        
        for (int i : result) {
            System.out.print(i + ", ");
        }

        System.out.println();
    }

    private int preOrderRec(Node root, int[] result, int index) {
        if (root == null) {
            return index; // Base case
        }
        result[index] = root.getKey();
        index++;
        
        index = preOrderRec(root.getLeftChild(), result, index);
        index = preOrderRec(root.getRightChild(), result, index);

        return index;
    }

}
