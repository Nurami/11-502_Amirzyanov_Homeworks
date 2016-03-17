package ru.itis.inform;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HumansReaderWriter n = new HumansReaderWriter();
        LinkedList<Human> k = n.read();
        HumansSorter a = new HumansSorter();
        a.sort(k);
        n.write(k);
    }
}
