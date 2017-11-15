package queue;

public class LinkedQueue<T> implements QueueInterface<T> {
    protected LLNode<T> front;//the pointer of the queue which points to the front
    protected LLNode<T> rear;//the pointer of the queue which points to the rear
    protected int numElements = 0;//the number of the elements in the queue

    //the constructor
    public LinkedQueue() {
        front = null;
        rear = null;
    }

    //test the queue is full or not
    public boolean isFull() {
        return false;
    }

    //test the queue is empty or not
    public boolean isEmpty() {
        return numElements == 0;
    }

    //find out the number of elements in the queue
    public int size() {
        return numElements;
    }

    //add the element in rear of the queue
    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<T>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setLink(newNode);
            rear = newNode;
        }
        numElements++;
    }

    //remove the element form the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException("the queue is empty");
        } else {
            T element = front.getElement();
            front = front.getLink();
            if (front == null) {
                rear = null;
            }
            numElements--;
            return element;

        }
    }

}
