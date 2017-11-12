package list;

import java.util.Comparator;

public class SortedLinkedList<T extends Comparable<T>> extends UnSortedLinkedList<T> {
    private Comparator<T> comp;

    public SortedLinkedList() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    public SortedLinkedList(Comparator comp) {
        this.comp = comp;
    }

    public boolean add(T target) {
        if (numElements == 0) {
            head = new Node<T>(target);

        } else {
            boolean added = false;
            previous = head;
            location = previous.getNext();
            Node<T> temp = new Node<T>(target);
            if (comp.compare(head.getElement(), target) > 0) {
                temp.setNext(head);
                head = temp;
            } else {
                while (location != null) {
                    if (comp.compare(previous.getElement(), target) < 0
                            && comp.compare(location.getElement(), target) > 0) {

                        previous.setNext(temp);
                        temp.setNext(location);
                        added = true;
                        break;
                    } else {
                        previous = location;
                        location = location.getNext();
                    }
                }
                if (!added) {
                    previous.setNext(temp);
                }

            }
        }

        numElements++;
        return true;

    }

    public SortedLinkedList<Integer> myFind(T target) {
        SortedLinkedList<Integer> sll = new SortedLinkedList<Integer>();
        location = head;
        int time = 1;
        while (location != null) {
            if (comp.compare(location.getElement(), target) == 0) {
                sll.add(time);
            }
            previous = location;
            location = location.getNext();
            time++;
        }
        return sll;
    }


}
