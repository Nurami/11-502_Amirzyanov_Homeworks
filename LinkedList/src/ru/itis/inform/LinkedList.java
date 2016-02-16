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
            count++;
        } else {
            newNode.setNext(this.first);
            first = newNode;
            count++;
        }
    }

    public void remove(int element) {
        Node node = first;
        for (int i=0; i<count-1; i++) {
            if ((i==0) && (node.getValue()==element)){
                first=node.getNext();
                count--;
            }
            else {
                if (node.getNext().getValue() == element) {
                    node.setNext(node.getNext().getNext());
                    count--;
                }
                node = node.getNext();
            }
        }
    }
}
