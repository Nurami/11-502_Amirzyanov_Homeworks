package ru.itis.inform;

/**
 * Created by Nurami on 11.02.2016.
 */
public interface Graph {
    void addVertex();
    void addEdge(int vertexA, int vertexB, int weight);
    void showGraph();
}

