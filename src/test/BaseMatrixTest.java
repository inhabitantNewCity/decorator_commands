package test;

import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseMatrixTest {

    @Test
    public void getElementSimpleGet() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        assertEquals(3,matrix.getElement(0,2));
    }

    @Test
    public void getN() {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        assertEquals(3,matrix.getN());
    }

}