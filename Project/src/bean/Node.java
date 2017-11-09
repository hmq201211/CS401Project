package bean;

public class Node <E>{
	private E information;
	private Node<E> next;
	private Node<E> previous;
	public Node() {
		information=null;
		next=null;
		previous=null;
	}
	public Node<E> getPrevious() {
		return previous;
	}
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	public Node(E information) {
		this.information=information;
		next=null;
		previous=null;
	}
	public E getInformation() {
		return information;
	}
	public void setInformation(E information) {
		this.information = information;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return information.toString();
	}
	

}
