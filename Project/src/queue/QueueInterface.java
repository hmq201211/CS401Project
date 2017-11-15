package queue;

public interface QueueInterface<T> {
    void enqueue(T element) throws QueueOverflowException;//add element in the rear of the queue

    T dequeue() throws QueueUnderflowException;//remove element form the front of the queue

    boolean isFull();//test the queue is full or not

    boolean isEmpty();//test the queue is empty or not

    int size();//find out the number of elements of the queue
}
