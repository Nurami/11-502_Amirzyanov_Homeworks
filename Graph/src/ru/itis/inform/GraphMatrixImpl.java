package ru.itis.inform;

import ru.itis.inform.Graph;

/**
 * Created by Nurami on 11.02.2016.
 */
public class GraphMatrixImpl implements Graph {

        private static final int DEFAULT_SIZE = 50;
        private int matrix[][];
        private int verticesCount;
        private int maxSize;

        public GraphMatrixImpl() {
            initGraph(DEFAULT_SIZE);
        }

        public GraphMatrixImpl(int maxSize) {
            initGraph(maxSize);
        }

        private void initGraph(int maxSize) {
            this.maxSize = maxSize;
            this.verticesCount = 0;
            this.matrix = new int[maxSize][maxSize];
        }

        public void addVertex() {
            if (this.verticesCount < this.maxSize) {
                this.verticesCount++;
            } else throw new IllegalArgumentException();
        }

        public void addEdge(int vertexA, int vertexB, int weight) {
            if (vertexA < verticesCount && vertexB < verticesCount) {
                this.matrix[vertexA][vertexB] = weight;
            } else throw new IllegalArgumentException();
        }

        public void showGraph() {
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount - 1; j++) {
                    System.out.print(matrix[i][j] + ",  ");
                }
                System.out.println(matrix[i][verticesCount - 1]);
            }
        }
    }


