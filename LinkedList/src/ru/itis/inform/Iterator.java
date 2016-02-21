package ru.itis.inform;

/**
 * Created by Nurami on 18.02.2016.
 */
public interface Iterator <T> {
    boolean hasNext();
    boolean hasPrevious();
    T next();
    T previous();
    T peekPrevious();
    T peekNext();
    void insert (T element);
}
