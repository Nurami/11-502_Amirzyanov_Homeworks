package ru.itis.inform;


/**
 * Created by Nurami on 24.02.2016.
 */
public class ArrayList<T> {

    private final int MAX_SIZE = 100;

    private Object elements[];

    private int count;
    public ArrayList() {
        elements = new Object[MAX_SIZE];
    }

    public void add(T element) {
        this.elements[count] = element;
        count++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < this.count) {
            return (T)this.elements[index];
        } else throw new IllegalArgumentException();
    }
    public T append(LinkedList list) {
        for (int i = 0; i<=100; i++) {

            if (this.elements[i] != null) {

                LinkedList<Human> linkedList = (LinkedList<Human>) elements[i];
                Node<Human> newNode = linkedList.getAge();

                while (newNode != null) {
                    list.add(newNode.getValue());
                    newNode = newNode.getNext();
                }
            }
        }
        return (T)list;
    }
}