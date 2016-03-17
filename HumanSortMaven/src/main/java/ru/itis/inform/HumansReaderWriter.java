package ru.itis.inform;

import java.io.*;



/**
 * Created by Nurami on 25.02.2016.
 */
public class HumansReaderWriter {


    public LinkedList<Human> read() throws IOException {
        LinkedList<Human> exp = new LinkedList<Human>();
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSortMaven\\src\\main\\java\\ru\\itis\\inform\\Humans.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            String[] a = line.split(" ");
            Human human = new Human(a[0], a[1]);
            exp.addEnd(human);
        }

        in.close();
        return exp;
    }

    public void write(LinkedList<Human> qq) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(new File("C:\\Users\\Nurami\\Documents\\IdeaProjects\\HumanSortMaven\\src\\main\\java\\ru\\itis\\inform\\HumansSort.txt"));

        Iterator<Human> iterator = qq.iterator();

        while (iterator.hasNext()) {
            wr.println(iterator.pickNext().toString());
            iterator.next();
        }
        wr.close();

    }
}



