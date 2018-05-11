package test.decoratores;

import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import main.decoratores.MinorMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinorMatrixTest {

    @Test
    public void getElement() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,1};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertEquals(1, matrix.getElement(0,0));
    }

    @Test
    public void getElementNull() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,1,1,2};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertNull(matrix.getElement(0,0));
    }

    @Test
    public void getElementNullInd() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,7};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertNull(matrix.getElement(1,7));
    }

    @Test
    public void getElementNullInds() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,7};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertNull(matrix.getElement(1,1));
    }

    @Test
    public void getElementEmptyInd() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertNull(matrix.getElement(0,0));
    }

    @Test
    public void getN() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,1};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertEquals(2, matrix.getN());
    }

    @Test
    public void getNNull() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        int[] indexes = {1,1,1,1,1};
        IMatrix matrix = new BaseMatrix(elements);
        matrix = new MinorMatrix(matrix, indexes);
        assertEquals(-1, matrix.getN());
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