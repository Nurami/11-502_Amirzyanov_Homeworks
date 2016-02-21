package ru.itis.inform;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nurami on 18.02.2016.
 */
public class GraphMatrixImplTest {
    private GraphMatrixImpl graph = new GraphMatrixImpl(5);



    @Test
    public void testRunFloid() throws Exception {
        int mass[][] = new int [5][5];




        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 4, 5);

        mass[0][0] = 0;
        mass[0][1] = 5;
        mass[0][2] = 1;
        mass[0][3] = 2;
        mass[0][4] = 5;
        mass[1][0] = 5;
        mass[1][1] = 0;
        mass[1][2] = 4;
        mass[1][3] = 7;
        mass[1][4] = 9;
        mass[2][0] = 1;
        mass[2][1] = 4;
        mass[2][2] = 0;
        mass[2][3] = 3;
        mass[2][4] = 5;
        mass[3][0] = 2;
        mass[3][1] = 7;
        mass[3][2] = 3;
        mass[3][3] = 0;
        mass[3][4] = 3;
        mass[4][0] = 5;
        mass[4][1] = 9;
        mass[4][2] = 5;
        mass[4][3] = 3;
        mass[4][4] = 0;
        graph.runFloid();


        assertArrayEquals(mass, graph.floidmatrix );







    }
}