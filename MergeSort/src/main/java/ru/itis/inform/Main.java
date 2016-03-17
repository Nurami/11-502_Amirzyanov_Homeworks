package ru.itis.inform;

/**
 * Created by Nurami on 15.03.2016.
 */
public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addEnd(8);
        list.addEnd(3);
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(5);
        list.addEnd(7);
        list.addEnd(4);
        list.addEnd(6);
        list.addEnd(9);
        LinkedList result = new LinkedList();
        MergeSort sort = new MergeSort();
        result = sort.mergeSort(list);
        result.showMe(result);



    }
}
