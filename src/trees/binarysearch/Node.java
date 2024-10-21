package trees.binarysearch;

/**
 * Node
 */
public class Node {

    private int key;
    private Node father;
    private Node leftChild;
    private Node rightChild;

    public Node(int key) {
        this.key = key;
        this.father = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        String fatherKey = (father != null) ? String.valueOf(father.getKey()) : "null";
        String leftChildKey = (leftChild != null) ? String.valueOf(leftChild.getKey()) : "null";
        String rightChildKey = (rightChild != null) ? String.valueOf(rightChild.getKey()) : "null";
        
        return "Node{" +
                "key=" + key +
                ", father=" + fatherKey +
                ", leftChild=" + leftChildKey +
                ", rightChild=" + rightChildKey +
                '}';
    }
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
