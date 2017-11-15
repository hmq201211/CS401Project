package binarySearchTree;

public class BSTNode<T> {
    private T info;//the information which the node contains
    private BSTNode<T> left;// the node which smaller than the node
    private BSTNode<T> right;// the node which bigger than the node

    // the constructor
    public BSTNode(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    //the setters and getter methods
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "info=" + info +
                '}';
    }

}
