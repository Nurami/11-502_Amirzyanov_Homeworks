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
                el.addEnd(chel);
                arraylist.add(number, el);
            } else {
                LinkedList<Human> el = (LinkedList<Human>) arraylist.get(number);
                el.addEnd(chel);
            }
            node = node.getNext();
        }
        int k=0;
        while (arraylist.get(k)== null) {
            k++;
        }
        LinkedList<Human> resultList = new LinkedList<Human>();
        resultList = arraylist.get(k);

        for (int i = k+1; i < 100; i++) {
            if (arraylist.get(i)!=null) {
                resultList.append(arraylist.get(i));
            }
        }
        return arraylist.get(0);
    }
}
