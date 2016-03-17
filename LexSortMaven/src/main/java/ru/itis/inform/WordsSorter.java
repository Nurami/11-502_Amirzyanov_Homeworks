package ru.itis.inform;


public class WordsSorter {

    public LinkedList<Word> sort(LinkedList<Word> element) {



        LinkedList<Word> resultList = element;
        int z =0;
        while (z!= 5) { // длина слова
            Node<Word> node = resultList.getFirst();
            ArrayList<LinkedList<Word>> arraylist = new ArrayList<LinkedList<Word>>();
            while (node != null) {
                Word slov = node.getValue();
                String word = slov.getSlovo();
                int num = (int) word.charAt(word.length() - z-1) - 97;
                if (arraylist.get(num) == null) {
                    LinkedList<Word> el = new LinkedList<Word>();
                    el.addEnd(slov);
                    arraylist.add(num, el);
                } else {
                    LinkedList<Word> el = (LinkedList<Word>) arraylist.get(num);
                    el.addEnd(slov);
                }
                node = node.getNext();
            }

            resultList = new LinkedList<Word>();


            int k = 0;
            while (arraylist.get(k) == null) {
                k++;
            }

            resultList = arraylist.get(k);

            for (int i =k+1; i < 31; i++) {
                if (arraylist.get(i) != null) {
                    Iterator<Word> it = arraylist.get(i).iterator();
                    while(it.hasNext()){
                        resultList.addEnd(it.pickNext());
                        it.next();
                    }
                }
            }

            z++;
        }
        return resultList;
    }
}
