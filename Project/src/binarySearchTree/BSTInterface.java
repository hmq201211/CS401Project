package binarySearchTree;

import java.util.Iterator;

public interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T> {
    enum Traversal {Inorder, Preorder, Postorder}

    T min();

    T max();

    Iterator<T> getIterator(Traversal orderType);
}
