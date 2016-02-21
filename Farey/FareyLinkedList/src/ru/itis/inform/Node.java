package ru.itis.inform;

/**
 * Created by Nurami on 16.02.2016.
 */
public class Node {
    private RationalNumber value;
    private Node next;

    public Node(RationalNumber value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next  = next;
    }

    public RationalNumber getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}