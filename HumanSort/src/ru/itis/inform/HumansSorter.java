package ru.itis.inform;


public class HumansSorter  {

    public LinkedList<Human> sort(LinkedList<Human> humanLinkedList) {

        ArrayList<LinkedList<Human>> arrayList = new ArrayList<>();

        Node<Human> newnode = humanLinkedList.getAge();

        while (newnode != null) {
            int currentAge = newnode.getValue().getAge();

            arrayList.getIndex(currentAge).push(newnode.getValue());

            newnode = newnode.getNext();
        }
        LinkedList<Human> newHumanLinkedList = new LinkedList<Human>();

        newHumanLinkedList = arrayList.append(newHumanLinkedList);

        return newHumanLinkedList;
    }
}