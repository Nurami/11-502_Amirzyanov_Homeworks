package ru.itis.inform;



public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void append (T element) {



    }

    public void addEnd (T element) {
        Node newNode = new Node<T>(element);
        newNode.setNext(null);
        if (last == null) {
            this.last = newNode;
        }
        else {
            newNode.setPrevious(this.last);
            last.setNext(newNode);
            last = newNode;
        }
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
}
