package queue;

public class LinkedQueue<T> implements QueueInterface<T> {
	protected LLNode<T> front;
	protected LLNode<T> rear;
	protected int numElements=0;
	public LinkedQueue(){
		front=null;
		rear=null;
	}
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return numElements==0;
	}
	public int size() {
		return numElements;
	}
	public void enqueue(T element) {
		LLNode<T> newNode= new LLNode<T>(element);
		if(rear==null) {
			front=newNode;
			rear= newNode;					
		}
		else {
			rear.setLink(newNode);
			rear=newNode;
		}
		numElements++;
	}
	public T dequeue() {
		if(isEmpty()) {
			throw new QueueUnderflowException("the queue is empty");
		}
		else {
			T element = front.getElement();
			front= front.getLink();
			if(front==null) {
				rear=null;
			}
			numElements--;
			return element;
			
		}
	}

}
