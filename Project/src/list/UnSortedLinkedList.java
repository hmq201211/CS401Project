package list;

import java.util.Iterator;

public class UnSortedLinkedList<T extends Comparable<T>> implements ListInterface<T> {
    protected Node<T> head;
    protected int numElements;
    protected boolean found;
    protected Node<T> location;
    protected Node<T> previous;

    public UnSortedLinkedList() {
        head = null;
        numElements = 0;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(T target) {
        if (numElements == 0) {
            head = new Node<T>(target);

        } else {
            location = head;
            while (location.getNext() != null) {
                location = location.getNext();
            }
            location.setNext(new Node<T>(target));
        }
        numElements++;
        return true;

    }

    @Override
    public T get(T target) {
        find(target);
        if (found)
            return target;
        else
            return null;

    }

    @Override
    public boolean contains(T target) {
        find(target);
        return found;
    }

    public boolean remove(T target) {
        find(target);
        if (found) {
            if (numElements == 1) {
                head = null;
            } else {
                previous.setNext(location.getNext());
            }
            numElements--;
            return true;
        } else {
            return false;
        }
    }


    protected void find(T target) {
        location = head;
        found = false;
        while (location != null) {
            if (location.getElement().equals(target)) {
                found = true;
                break;
            } else {
                previous = location;
                location = location.getNext();
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        location = head;
        while (location != null) {
            sb.append(location.getElement());
            sb.append("\n");
            location = location.getNext();
        }
        return sb.toString();
    }

    public int size() {
        return numElements;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    throw new IndexOutOfBoundsException("illegal invocation of next");
                } else {
                    T toReturn = currentNode.getElement();
                    currentNode = currentNode.getNext();
                    return toReturn;
                }

            }
        };
    }


}
