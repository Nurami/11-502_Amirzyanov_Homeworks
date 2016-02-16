package ru.itis.inform;

import ru.itis.inform.Graph;

/**
 * Created by Nurami on 11.02.2016.
 */
public class GraphMatrixImpl implements Graph {

        private static final int DEFAULT_SIZE = 50;
        private int matrix[][];
        private int floidmatrix[][];
        private int verticesCount;
        private int maxSize;



        public GraphMatrixImpl() {
            initGraphs(DEFAULT_SIZE);
        }

        public GraphMatrixImpl(int maxSize) {
            initGraphs(maxSize);
        }

        private void initGraphs(int maxSize) {
            this.maxSize = maxSize;
            this.verticesCount = 0;
            this.matrix = new int[maxSize][maxSize];
            this.floidmatrix = new int [maxSize][maxSize];
        }


        public void addVertex() {
            if (this.verticesCount < this.maxSize) {
                this.verticesCount++;
            } else throw new IllegalArgumentException();
        }

        public void addEdge(int vertexA, int vertexB, int weight) {
            if (vertexA < verticesCount && vertexB < verticesCount) {
                this.matrix[vertexA][vertexB] = weight;
                this.matrix[vertexB][vertexA] = weight;
                this.floidmatrix[vertexA][vertexB] = weight;
                this.floidmatrix[vertexB][vertexA] = weight;
            } else throw new IllegalArgumentException();
        }

        public void doFloid() {
            for (int k = 0; k < verticesCount; k++) {
                for (int i = 0; i < verticesCount; i++) {
                    for (int j = 0; j < verticesCount; j++) {
                        if ((floidmatrix[i][k] != 0) && (floidmatrix[k][j] != 0) && (i!=j)) {
                            if ((floidmatrix[i][j] > floidmatrix[i][k] + floidmatrix[k][j]) || (floidmatrix[i][j] == 0)) {
                                floidmatrix[i][j] = floidmatrix[i][k] + floidmatrix[k][j];
                            }


                        }
                    }
                }
            }
        }



        public void showGraph() {
            for (int i = 0; i < verticesCount; i++) {
                for (int j = 0; j < verticesCount - 1; j++) {
                    System.out.print(matrix[i][j] + ",  ");
                }
                System.out.println(matrix[i][verticesCount - 1]);
            }
        }
    public void showFloidmatrix() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount - 1; j++) {
                System.out.print(floidmatrix[i][j] + ",  ");
            }
            System.out.println(floidmatrix[i][verticesCount - 1]);
        }
    }
    }


