package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by Nurami on 25.02.2016.
 */
public class HumansReaderWriter {


    public LinkedList<Human> read() throws FileNotFoundException {
        LinkedList<Human> exp = new LinkedList<>();
        Scanner in = new Scanner(new File("Humans.txt"));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] a = line.split(" ");
            Human human = new Human(a[0], a[1]);
            exp.add(human);
        }

        in.close();
        return exp;
    }

    public LinkedList<Human> write(LinkedList<Human> element) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("Humans.txt"));
        out.print(element);
        out.close();
        return null;
    }
}


