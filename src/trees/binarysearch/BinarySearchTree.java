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

    public boolean remove(int key) {
        Node node = find(key);
        
        if (node != null) {
            Node father = node.getFather();

            // Remove the root
            if (father == null) {
                root = null;
                return true;
            }
 
            // Remove leaf
            if (node.getLeftChild() == null && node.getRightChild() == null) {

                // Verify which child remove
                if (father.getLeftChild() == node) {
                    father.setLeftChild(null);
                    return true;
                }

                if (father.getRightChild() == node) {
                    father.setRightChild(null);
                    return true;
                }
            }

            // If the node have one child
            if (node.getLeftChild() == null || node.getRightChild() == null) {
                
                // The right child turns to father
                // if (node.getLeftChild() == null) {
                //     node.getFather().setRightChild(node.getRightChild());
                //     node.getRightChild().setFather(node.getFather());
                //     return true;
                // }
                
                // // The left child turns to father
                // if (node.getRightChild() == null) {
                //     node.getFather().setLeftChild(node.getRightChild());
                //     node.getRightChild().setFather(node.getFather());
                //     return true;
                // }
            }

            // If the node have two childs
            // ...
        }

        // The node doesnt exist in the tree (node == null)
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

    public int height() {
        int height = heightRec(this.root);
        return height;
    }

    private int heightRec(Node root) {
        if (root == null) { // Base case
            return -1;
        }

        int heightLeft = heightRec(root.getLeftChild());
        int heightRight = heightRec(root.getRightChild());

        if (heightLeft >= heightRight) {
            return 1 + heightLeft;
        } else {
            return 1 + heightRight;
        }
    }

    public Node find(int key) {
        Node node = findRec(this.root, key);
        return node;
    }

    private Node findRec(Node root, int key) {
        if (root == null) { // Base case
            return null;
        }

        if (key == root.getKey()) {
            return root;
        }

        if (key <= root.getKey()) return findRec(root.getLeftChild(), key);
        else return findRec(root.getRightChild(), key);
    }

    /*
     * TRAVERSES
     * Pre Order
     * In Order
     * Post Order
     */

    public void displayPreOrder() {
        preOrderRec(this.root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getKey() + " ");
        preOrderRec(root.getLeftChild());
        preOrderRec(root.getRightChild());
    }


    public void displayInOrder() {
        inOrderRec(this.root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root == null) {
            return;
        }

        inOrderRec(root.getLeftChild());
        System.out.print(root.getKey() + " ");
        inOrderRec(root.getRightChild());
    }

    public void displayPostOrder() {
        postOrderRec(this.root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root == null) {
            return;
        }

        postOrderRec(root.getLeftChild());
        postOrderRec(root.getRightChild());
        System.out.print(root.getKey() + " ");
    }

}