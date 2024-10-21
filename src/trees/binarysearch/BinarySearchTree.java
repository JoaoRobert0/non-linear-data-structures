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

            if (father == null) {
                root = null;
            } else {
                if (father.getLeftChild() == node) {
                    father.setLeftChild(null);
                } else {
                    father.setRightChild(null);
                }
                node.setFather(null);
            }
            return true;
        }

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

    public boolean search(int key) {
        boolean exist = searchRec(this.root, key);
        return exist;
    }

    public boolean searchRec(Node root, int key) {
        if (root == null) { // Base case
            return false;
        }

        if (key == root.getKey()) {
            return true;
        }

        if (key <= root.getKey()) return searchRec(root.getLeftChild(), key);
        else return searchRec(root.getRightChild(), key);

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
