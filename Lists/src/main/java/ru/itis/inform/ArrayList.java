package ru.itis.inform;


/**
 * Created by Nurami on 24.02.2016.
 */
public class ArrayList<T> {

    private final int MAX_SIZE = 32;

    private Object elements[];

    private int count;

    public int getCount() {
        return count;
    }

    public ArrayList() {
        elements = new Object[MAX_SIZE];
    }

    public void add(int index, T element) {
        this.elements[index] = element;
        count++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if ((index >= 0)) {
            return (T)this.elements[index];
        } else throw new IllegalArgumentException();
    }

}