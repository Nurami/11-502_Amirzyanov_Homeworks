package ru.itis.inform;

/**
 * Created by Nurami on 14.02.2016.
 */
public interface List <T> {
    void add(T element);
    void remove(T element);
    Iterator<T> iterator();
}
