package ru.itis.inform;

/**
 * Created by Nurami on 16.02.2016.
 */
public class FareyLinkedList implements List{
    private LinkedList file;
    private int n;
    public void FareyLinkedList(int n){
        initList(n);
    }
    private void initList(int n){
        this.n=n;
        this.file = new LinkedList();
        this.file.add(new RationalNumber(0,1));
        this.file.add(new RationalNumber(1,1));
    }

    public void generate() {
        for (int index = 2; index < n; index++) {
            Node node = file.getFirst();
            do {
                if (node.getValue().getB() + node.getNext().getValue().getB() == index) {
                    int number = node.getValue().getA() + node.getNext().getValue().getA();
                    Node newNode = new Node(new RationalNumber(number, index));
                    newNode.setNext(node.getNext());
                    node.setNext(newNode);
                }
                node = node.getNext();
            } while (node.getNext() != null);
        }
    }
}