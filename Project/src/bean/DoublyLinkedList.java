package bean;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int numElements;

	private Node<E> location;
	private boolean found;

	private class DLLIterator implements ListIterator<E> {
		private Node<E> currentNode;
		private int count;

		public DLLIterator() {
			// TODO Auto-generated constructor stub
			currentNode = head;
			count = 0;
		}

		public DLLIterator(Where where) {
			if (where == Where.FRONT) {
				currentNode = head;
				count = 0;
			} else if (where == Where.BACK) {
				currentNode = tail;
				count = numElements;
			}

		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				E toReturn = currentNode.getInformation();
				currentNode = currentNode.getNext();
				count++;
				return toReturn;
			}
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return count;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			} else {
				E toReturn = currentNode.getInformation();
				currentNode = currentNode.getPrevious();
				count--;
				return toReturn;
			}
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return count;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub

		}

	}

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	private void find(E element) {
		location = head;
		found = false;
		if (numElements == 0) {
			return;
		} else {
			while (location != null) {
				if (location.getInformation().equals(element)) {
					found = true;
					break;
				}
				location = location.getNext();
			}
		}
	}

	public boolean contains(E element) {
		find(element);
		return found;
	}

	public E remove(int i) {
		if (i < 0 || i >= numElements) {
			return null;
		} else {
			E toReturn = null;
			if (numElements == 1) {
				if (i == 0) {
					toReturn = head.getInformation();
					head = null;
					tail = null;
				}
			} else if (i == 0) {
				toReturn = head.getInformation();
				head = head.getNext();
				head.setPrevious(null);
			} else if (i == numElements - 1) {
				toReturn = tail.getInformation();
				tail = tail.getPrevious();
				tail.setNext(null);
			} else {
				location = head;
				while (i > 0) {
					location = location.getNext();
					i--;
				}
				toReturn = location.getInformation();
				location.getPrevious().setNext(location.getNext());
				location.getNext().setPrevious(location.getPrevious());
			}
			numElements--;
			return toReturn;
		}
	}

	public boolean add(E element) {
		return add(Where.BACK, element);
	}

	public boolean add(Where where, E element) {
		if (where == Where.FRONT) {
			location = head;
			head = new Node<E>(element);
			head.setNext(location);
			if (tail == null) {
				tail = head;
			} else {
				location.setPrevious(head);
			}

		} else if (where == Where.BACK) {
			location = tail;
			tail = new Node<E>(element);
			tail.setPrevious(location);
			if (head == null) {
				head = tail;
			} else {
				location.setNext(tail);
			}

		} else {
			return false;
		}
		numElements++;
		return true;

	}

	public boolean add(Where where, int index, E element) {
		if (where == Where.MIDDLE && index >= 1 && index <= numElements - 1) {
			location = head;
			while (index > 0) {
				location = location.getNext();
				index--;
			}
			Node<E> node = new Node<E>(element);
			node.setPrevious(location.getPrevious());
			node.setNext(location);
			location.getPrevious().setNext(node);
			location.setPrevious(node);
			numElements++;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		location = head;
		while (location != null) {
			sb.append(location.getInformation());
			sb.append("\n");
			location = location.getNext();
		}
		return sb.toString();
	}

	@Override
	public ListIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new DLLIterator();
	}

	public void print_from_beginning() {
		ListIterator<E> li = iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
	}

	public void print_from_end() {
		ListIterator<E> li = new DLLIterator(Where.BACK);
		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
