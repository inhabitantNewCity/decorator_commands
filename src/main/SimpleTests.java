package main;

import main.decoratores.*;

public class SimpleTests {
    public static void main(String[] args) {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};

        IMatrix matrix = new BaseMatrix(elements);
        printMatrix(matrix);

        matrix = new TransportMatrix(matrix);
        printMatrix(matrix);

        matrix = new ZeroElementsMatrix(matrix);
        printMatrix(matrix);

        int[] indexes = {1, 2};
        matrix = new MinorMatrix(matrix, indexes);
        printMatrix(matrix);

        matrix = new BaseMatrix(elements);
        matrix.setElement(6, 1,0);
        printMatrix(matrix);

        matrix = new TransportMatrix(matrix);
        matrix.setElement(5, 1,2);
        printMatrix(matrix);

        matrix = new ZeroElementsMatrix(matrix);
        matrix.setElement(7, 2,0);
        printMatrix(matrix);

        matrix = matrix.revertOperation();
        printMatrix(matrix);

        matrix = new MinorMatrix(matrix, indexes);
        matrix.setElement(-1, 1,1);
        printMatrix(matrix);
    }

    public static void printMatrix(IMatrix m){
        for(int i = 0; i < m.getN(); i++){
            for(int j = 0; j < m.getN(); j++){
                System.out.print(m.getElement(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
