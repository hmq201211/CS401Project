package list;

import java.util.Iterator;

public class UnSortedLinkedList<T extends Comparable<T>> implements ListInterface<T> {
    protected Node<T> head;//the pointer of the list
    protected int numElements;//the number of the elements
    protected boolean found;//when call the find method,use this flag to indicate whether find the element or not
    protected Node<T> location;//the pointer used to indicate the location of the target
    protected Node<T> previous;//the pointer used to indicate the location before the target

    //the constructor
    public UnSortedLinkedList() {
        head = null;
        numElements = 0;
    }

    //indicate whether the list is full or not
    public boolean isFull() {
        return false;
    }

    //find out whether the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // add an element to the list
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

    //get the target from the list
    @Override
    public T get(T target) {
        find(target);
        if (found)
            return target;
        else
            return null;

    }

    //find out whether the list contains the target or not
    @Override
    public boolean contains(T target) {
        find(target);
        return found;
    }

    //remove the target from the list
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

    //the private method which used tor help find the location of the target
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

    //return the size of the list
    public int size() {
        return numElements;
    }

    //return the iterator which used to iterate the elements
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
