package ru.itis.inform;

/**
 * Created by Nurami on 14.02.2016.
 */
public class LinkedList<T> implements List<T> {
    private Node<T> first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void add(T element) {
        Node newNode = new Node<T>(element);
        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first.setPrevious(newNode);
            first = newNode;
        }
        this.count++;
    }

    public void remove(T element) {
        Node node = first;
        for (int i = 0; i < count - 1; i++) {
            if ((i == 0) && (node.getValue() == element)) {
                first = node.getNext();
            } else {
                if (node.getNext().getValue() == element) {
                    node.setNext(node.getNext().getNext());
                }
                node = node.getNext();
            }
            count--;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
}
