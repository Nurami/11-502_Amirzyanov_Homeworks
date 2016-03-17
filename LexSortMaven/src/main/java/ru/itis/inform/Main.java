package ru.itis.inform;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        WordsReaderWriter n = new WordsReaderWriter();
        LinkedList<Word> k = n.read();
        WordsSorter a = new WordsSorter();
        k=a.sort(k);
        n.write(k);
    }
}
