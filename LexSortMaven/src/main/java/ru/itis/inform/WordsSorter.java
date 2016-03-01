package ru.itis.inform;


public class WordsSorter {

    public LinkedList<Word> sort(LinkedList<Word> element) {

        ArrayList<LinkedList<Word>> arraylist = new ArrayList<LinkedList<Word>>();
        Node<Word> node = element.getFirst();
        int z =0;
        while (z!= 6) { // длина слова
            while (node != null) {
                Word slov = node.getValue();
                String word = slov.getSlovo();
                int num = (int) word.charAt(word.length()) - 97 - z;
                if (arraylist.get(num) == null) {
                    LinkedList<Word> el = new LinkedList<Word>();
                    el.add(slov);
                    arraylist.add(num, el);
                } else {
                    LinkedList<Word> el = (LinkedList<Word>) arraylist.get(num);
                    el.add(slov);
                }
                node = node.getNext();
            }
            int k = 0;
            while (arraylist.get(k) == null) {
                k++;
            }
            LinkedList<Word> resultList = arraylist.get(k + 1);

            for (int i = 0; i < 100; i++) {
                element.append(arraylist.get(i));
            }
            z++;
        }
        return element;
    }
}
