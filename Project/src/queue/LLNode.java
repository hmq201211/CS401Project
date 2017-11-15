package queue;

public class LLNode<T> {
    private T element;//the information which the node contains
    private LLNode<T> link;//the node which connects to the node

    //the constructor
    public LLNode(T element) {
        this.element = element;
        this.link = null;
    }

    //the setters and getters
    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    public void setLink(LLNode<T> newNode) {
        this.link = newNode;
    }

    public LLNode<T> getLink() {
        return this.link;
    }

}
