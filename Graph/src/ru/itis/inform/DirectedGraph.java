package ru.itis.inform;

/**
 * Created by Nurami on 18.02.2016.
 */
public interface DirectedGraph {
    void addVertex();
    void addEdgeDirected(int vertexA, int vertexB, int weight);
    void runFloid();
}
