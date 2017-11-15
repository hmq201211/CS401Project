package binarySearchTree;

public interface CollectionInterface<T> {
    //add the element to the collection
    boolean add(T element);

    //get the target form the collection
    T get(T target);

    //find out that if the collection contains the target or not
    boolean contains(T target);

    //try to remove the target from the collection
    boolean remove(T target);

    //test the collection is full or not
    boolean isFull();

    //test the collection is empty or not
    boolean isEmpty();

    //find out the size of the collection
    int size();
}
