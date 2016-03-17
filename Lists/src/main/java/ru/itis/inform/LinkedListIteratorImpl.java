package ru.itis.inform;

/**
 * Created by Nurami on 18.02.2016.
 */

class LinkedListIteratorImpl<T> implements Iterator<T> {

    Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }


    public boolean hasNext() {
        return current != null;
    }


    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

    public boolean hasPrevious() {
        return current.getPrevious() != null;
    }


    public T previous() {
        if (hasPrevious()) {
            current = current.getPrevious();
            return current.getPrevious().getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void insert(T element) {
        if (hasPrevious() && hasNext()) {
            Node node = new Node<T>(element);

            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.getPrevious().setNext(node);
            current.setPrevious(node);
        }
    }

    public T pickNext() {
        return current.getValue();
    }

    public T pickPrevious() {
        return current.getPrevious().getValue();
    }
}



