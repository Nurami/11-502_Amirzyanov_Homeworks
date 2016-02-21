package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();




        list.add(5);
        list.add(7);
        list.add(10);
        list.add(14);
        list.add(17);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.peekNext() != 7) {
            iterator.insert(6);
            iterator.next();
        }


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

