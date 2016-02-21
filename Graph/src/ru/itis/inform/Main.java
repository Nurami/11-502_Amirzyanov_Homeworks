package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
            GraphMatrixImpl graph = new GraphMatrixImpl(100);

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

            graph.runFloid();

            graph.showGraph();
            graph.showFloidmatrix();
        }
    }
