package ru.itis.inform;

import java.io.*;



/**
 * Created by Nurami on 25.02.2016.
 */
public class HumansReaderWriter {


    public LinkedList<Human> read() throws IOException {
        LinkedList<Human> exp = new LinkedList<Human>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSort\\src\\ru\\itis\\inform\\Humans.txt"));
        String line;
        while ((line = in.readLine()) !=null) {
            String[] a = line.split(" ");
            Human human = new Human(a[0], a[1]);
            exp.add(human);
        }

        in.close();
        return exp;
    }

    public LinkedList<Human> write(LinkedList<Human> element) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSort\\src\\ru\\itis\\inform\\HumansSort.txt"));
        out.print(element);
        out.close();
        return null;
    }
}


