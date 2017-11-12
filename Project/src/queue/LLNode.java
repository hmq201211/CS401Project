package queue;

public class LLNode<T> {
	private T element;
	private LLNode<T> link;

	public LLNode(T element) {
		this.element = element;
		this.link = null;
	}

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
