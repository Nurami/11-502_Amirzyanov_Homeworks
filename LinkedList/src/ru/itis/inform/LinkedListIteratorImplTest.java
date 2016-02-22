package ru.itis.inform;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nurami on 22.02.2016.
 */
public class LinkedListIteratorImplTest {
    Node current;
    private LinkedListIteratorImpl file = new LinkedListIteratorImpl(current);

    @Test
    public void testInsert() throws Exception {
        LinkedList node1 = new LinkedList();
        LinkedList node2 = new LinkedList();


        node1.add(1);
        node2.add(3);

        node1.iterator().next();
        node1.iterator().insert(2);

        node2.add(3);
        node2.add(2);
        node2.add(1);

        equals (node1.iterator().previous() == node2.iterator().previous());
        equals (node1.iterator().next() == node2.iterator().next());


    }
}