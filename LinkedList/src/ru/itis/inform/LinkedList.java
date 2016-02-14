package ru.itis.inform;

/**
 * Created by Nurami on 14.02.2016.
 */
public class LinkedList implements List{
    private Node first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first = newNode;
        }
    }

    public void remove(int element) {
}
