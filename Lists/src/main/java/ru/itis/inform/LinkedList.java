package ru.itis.inform;



public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
        this.last = null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void append(LinkedList<T> secondList) {

        if (this.first == null) {
            Node<T> nodeSecondList = secondList.getFirst();

            this.first = nodeSecondList;
            Node<T> r = this.first;
            nodeSecondList = nodeSecondList.getNext();

            while (nodeSecondList != null) {
                r.setNext(nodeSecondList);
                nodeSecondList.setPrevious(r);
                r = r.getNext();
                nodeSecondList = nodeSecondList.getNext();
            }

        } else {
            Node<T> r = this.first;

            while (r.getNext() != null)
                r = r.getNext();

            Node<T> t = secondList.getFirst();

            while (t != null) {
                r.setNext(t);
                t.setPrevious(r);
                r = r.getNext();
                t = t.getNext();
            }
        }
    }

   /* public void append (LinkedList<T> element) {
        Node pre = element.getFirst();
        while (pre.getNext()!= null) {
            addEnd((T) pre);
            pre = pre.getNext();
        }

        this.last.setNext(element.getFirst());
        element.getFirst().setPrevious(this.last);
        this.last = element.getLast();*/

    public static <T extends Comparable> LinkedList<T> merge (LinkedList<T> ll1, LinkedList<T> ll2) {
        Iterator<T> it1 = ll1.iterator();
        Iterator<T> it2 = ll2.iterator();
        LinkedList<T> newlinkedlist = new LinkedList<T>();

        while ((it1.hasNext()) && (it2.hasNext())) {
            if (it1.pickNext().compareTo(it2.pickNext()) == -1) {
                newlinkedlist.addEnd(it1.pickNext());
                it1.next();
            } else {
                if (it1.pickNext().compareTo(it2.pickNext()) == 0) {
                    newlinkedlist.addEnd(it1.pickNext());
                    newlinkedlist.addEnd(it2.pickNext());
                    it1.next();
                    it2.next();

                } else {
                    if (it1.pickNext().compareTo(it2.pickNext()) == 1) {
                        newlinkedlist.addEnd(it2.pickNext());
                        it2.next();
                    }

                }

            }
        }
        while (it1.hasNext()) {
            newlinkedlist.addEnd(it1.next());
        }
        while (it2.hasNext()) {
            newlinkedlist.addEnd(it2.next());
        }
        return newlinkedlist;
    }

    public void showMe (LinkedList element) {
        Iterator it = element.iterator();
        while (it.hasNext()) {
            System.out.print(it.pickNext()+ "  ");
            it.next();
        }
    }


    public void addEnd (T element) {
        Node newNode = new Node<T>(element);
        newNode.setNext(null);
        if (first == null) {
            this.first = newNode;
            this.last = newNode;
        }
        else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public void add(T element) {
        Node newNode = new Node<T>(element);
        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
            this.last =newNode;
        } else {
            newNode.setNext(this.first);
            first.setPrevious(newNode);
            first = newNode;
        }
        this.count++;
    }

    public void remove(T element) {
        Node node = first;
        for (int i = 0; i < count - 1; i++) {
            if ((i == 0) && (node.getValue() == element)) {
                first = node.getNext();
            } else {
                if (node.getNext().getValue() == element) {
                    node.setNext(node.getNext().getNext());
                }
                node = node.getNext();
            }
            count--;
        }
    }
    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
}
