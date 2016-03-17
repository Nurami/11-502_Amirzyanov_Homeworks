package ru.itis.inform;

import java.io.*;



/**
 * Created by Nurami on 25.02.2016.
 */
public class WordsReaderWriter {


    public LinkedList<Word> read() throws IOException {
        LinkedList<Word> exp = new LinkedList<Word>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Nurami\\Documents\\IdeaProjects\\LexSortMaven\\src\\main\\java\\ru\\itis\\inform\\Words.txt"));
        String line;
        while ((line = in.readLine()) !=null) {
            String[] a = line.split(" ");
            for (int i=0; i<a.length;  i++){
                Word word = new Word(a[i]);
                exp.addEnd(word);
            }
        }

        in.close();
        return exp;
    }

    public void write(LinkedList<Word> qq) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(new File("C:\\Users\\Nurami\\Documents\\IdeaProjects\\LexSortMaven\\src\\main\\java\\ru\\itis\\inform\\SorterWords.txt"));

        Iterator<Word> iterator = qq.iterator();

        while (iterator.hasNext()) {
            wr.println(iterator.pickNext().toString());
            iterator.next();
        }
        wr.close();

    }
}


