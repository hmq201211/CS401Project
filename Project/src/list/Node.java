package list;

public class Node<T> {
    protected T element;//the element which the node contains
    protected Node<T> next;//the node which connect to the node

    //the constructor
    public Node(T element) {
        this.element = element;
        next = null;
    }

    //the setters and getters
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


}
