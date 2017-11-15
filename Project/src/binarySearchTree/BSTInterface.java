package binarySearchTree;

import java.util.Iterator;

public interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T> {
    //the three orders of the Traversal
    enum Traversal {
        Inorder, Preorder, Postorder
    }

    //return the smallest element of BST
    T min();

    //return the largest element of BST
    T max();

    //get the iterator which has the asked order
    Iterator<T> getIterator(Traversal orderType);
}
