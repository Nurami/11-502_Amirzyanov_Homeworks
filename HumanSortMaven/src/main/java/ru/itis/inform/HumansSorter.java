package ru.itis.inform;


public class HumansSorter {

    public LinkedList<Human> sort(LinkedList<Human> element) {

        ArrayList<LinkedList<Human>> arraylist = new ArrayList<LinkedList<Human>>();
        Node<Human> node = element.getFirst();
        while (node != null) {
            Human chel = node.getValue();
            String ageS = chel.getAge();
            int number = Integer.parseInt(ageS);
            if (arraylist.get(number) == null) {
                LinkedList<Human> el = new LinkedList<Human>();
                el.add(chel);
                arraylist.add(number, el);
            } else {
                LinkedList<Human> el = (LinkedList<Human>) arraylist.get(number);
                el.add(chel);
            }
            node = node.getNext();
        }
        int k=0;
        while (arraylist.get(k)== null) {
            k++;
        }
        LinkedList<Human> resultList = arraylist.get(k+1);

        for (int i = 0; i < 100; i++) {
            resultList.append(arraylist.get(i));

        }
        return resultList;
    }
}
