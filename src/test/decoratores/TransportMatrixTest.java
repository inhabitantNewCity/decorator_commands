package test.decoratores;

import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import main.decoratores.MinorMatrix;
import main.decoratores.TransportMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransportMatrixTest {

    @Test
    public void getElementSimpleGet() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new TransportMatrix(matrix);
        assertEquals(2,matrix.getElement(0,2));
    }

    @Test
    public void getElementDiogGet() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new TransportMatrix(matrix);
        assertEquals(1,matrix.getElement(1,1));
    }

    @Test
    public void getN() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new TransportMatrix(matrix);
        assertEquals(3,matrix.getN());
    }

    @Test
    public void revertOperation() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,1,1,1,1};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        matrix = matrix.revertOperation();
        assertEquals(1, matrix.getElement(0,0));
    }

}