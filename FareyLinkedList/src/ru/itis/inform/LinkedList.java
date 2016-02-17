package ru.itis.inform;

/**
 * Created by Nurami on 16.02.2016.
 */
public class LinkedList {
    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public void add(RationalNumber element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public Node getFirst() {
        return this.first;
    }
}
