package ru.itis.inform;

import java.io.*;



/**
 * Created by Nurami on 25.02.2016.
 */
public class WordsReaderWriter {


    public LinkedList<Word> read() throws IOException {
        LinkedList<Word> exp = new LinkedList<Word>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSort\\src\\ru\\itis\\inform\\Words.txt"));
        String line;
        while ((line = in.readLine()) !=null) {
            String[] a = line.split(" ");
            for (int i=0; i<a.length;  i++){
                Word word = new Word(a[i]);
                exp.add(word);
            }
        }

        in.close();
        return exp;
    }

    public LinkedList<Word> write(LinkedList<Word> element) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSort\\src\\ru\\itis\\inform\\WordsSorter.txt"));
        out.print(element);
        out.close();
        return null;
    }
}


