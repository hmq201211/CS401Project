package binarySearchTree;


import list.SortedLinkedList;
import queue.LinkedQueue;

import java.util.Comparator;
import java.util.Iterator;


public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
    protected BSTNode<T> root;
    protected Comparator<T> comp;
    protected boolean found;

    // the constructors for the BinarySearchTree class
    public BinarySearchTree() {
        root = null;
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    public BinarySearchTree(Comparator<T> comp) {
        root = null;
        this.comp = comp;

    }

    // return the smallest T
    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        } else {
            BSTNode<T> temp = root;
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp.getInfo();
        }
    }

    //return biggest T
    @Override
    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            return getPredecessor(root);
        }
    }

    //private method : returns the T which is less than the node ,but greater than others
    private T getPredecessor(BSTNode<T> node) {
        BSTNode<T> temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    //returns the iterator which has the the user's orderType
    @Override
    public Iterator<T> getIterator(Traversal orderType) {
        final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
        switch (orderType) {
            case Preorder:
                preOrder(root, infoQueue);
                break;
            case Postorder:
                postOrder(root, infoQueue);
                break;
            default:
                inOrder(root, infoQueue);
                break;
        }
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !infoQueue.isEmpty();
            }

            @Override
            public T next() {
                if (infoQueue.isEmpty()) {
                    throw new IndexOutOfBoundsException("illegal invocation of next");
                }
                return infoQueue.dequeue();
            }

            public void remove() {
                throw new UnsupportedOperationException("Unsupported remove attempted");
            }
        };

    }

    //private methods which help to create the iterator
    private void inOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            inOrder(node.getLeft(), infoQueue);
            infoQueue.enqueue(node.getInfo());
            inOrder(node.getRight(), infoQueue);
        }
    }

    private void postOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            postOrder(node.getLeft(), infoQueue);
            postOrder(node.getRight(), infoQueue);
            infoQueue.enqueue(node.getInfo());
        }
    }

    private void preOrder(BSTNode<T> node, LinkedQueue<T> infoQueue) {
        if (node != null) {
            infoQueue.enqueue(node.getInfo());
            preOrder(node.getLeft(), infoQueue);
            preOrder(node.getRight(), infoQueue);
        }
    }

    //add a element to the BST
    @Override
    public boolean add(T element) {
        root = recAdd(element, root);
        return true;
    }

    //use the recursive approach to add element
    private BSTNode<T> recAdd(T element, BSTNode<T> node) {
        if (node == null) {
            node = new BSTNode<T>(element);
        } else if (comp.compare(node.getInfo(), element) < 0) {
            node.setRight(recAdd(element, node.getRight()));
        } else {
            node.setLeft(recAdd(element, node.getLeft()));
        }
        return node;
    }

    //get the target for the BST,if doesn't exist.return null
    @Override
    public T get(T target) {
        return recGet(target, root);
    }

    //use the recursive approach to get the target
    private T recGet(T target, BSTNode<T> node) {
        if (node == null) {
            return null;
        } else if (comp.compare(target, node.getInfo()) > 0) {
            return recGet(target, node.getRight());
        } else if (comp.compare(target, node.getInfo()) < 0) {
            return recGet(target, node.getLeft());
        } else {
            return node.getInfo();
        }
    }

    //test if the BST contains the target
    @Override
    public boolean contains(T target) {
        return recContains(target, root);
    }

    //use the recursive approach to find out that if the target is in the BST
    private boolean recContains(T target, BSTNode<T> node) {
        if (node == null) {
            return false;
        } else if (comp.compare(node.getInfo(), target) > 0) {
            return recContains(target, node.getLeft());
        } else if (comp.compare(node.getInfo(), target) < 0) {
            return recContains(target, node.getRight());
        } else {
            return true;
        }
    }

    //remove the target from the BST
    @Override
    public boolean remove(T target) {
        root = recRemove(target, root);
        return found;
    }

    //use the recursive approach to remove the target
    private BSTNode<T> recRemove(T target, BSTNode<T> node) {
        if (node == null) {
            found = false;
        } else if (comp.compare(target, node.getInfo()) > 0) {
            node.setRight(recRemove(target, node.getRight()));
        } else if (comp.compare(target, node.getInfo()) < 0) {
            node.setLeft(recRemove(target, node.getLeft()));
        } else {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    //private method to help reset the node when it's removed from the BST
    private BSTNode<T> removeNode(BSTNode<T> node) {
        T data;
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }

    }

    //test the BST is full or not
    @Override
    public boolean isFull() {
        return false;
    }

    // test the BST is empty or not
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    //find out the size of the BST
    @Override
    public int size() {
        return recSize(root);
    }

    //recursive approach to help find the size of the BST
    private int recSize(BSTNode<T> node) {
        if (node == null)
            return 0;
        else
            return 1 + recSize(node.getLeft()) + recSize(node.getRight());
    }

    //return the default iterator of the BST usually inOrder
    @Override
    public Iterator<T> iterator() {
        return getIterator(Traversal.Inorder);
    }

    //recursive approach to find all the elements
    private SortedLinkedList<Integer> recMyFind(SortedLinkedList<Integer> sll, T target, BSTNode<T> node, int count) {
        if (node == null) {
            return sll;
        } else if (comp.compare(target, node.getInfo()) > 0) {
            return recMyFind(sll, target, node.getRight(), ++count);
        } else if (comp.compare(target, node.getInfo()) < 0) {
            return recMyFind(sll, target, node.getLeft(), ++count);
        } else {
            count++;
            sll.add(count);
            return recMyFind(sll, target, node.getLeft(), count);
        }
    }

    //find all the targets which have the same information and add the index of them to a SortedLinkedList
    public SortedLinkedList<Integer> myFind(T target) {
        return recMyFind(new SortedLinkedList<Integer>(), target, root, 0);
    }

}
