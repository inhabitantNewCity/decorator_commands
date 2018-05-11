package main.decoratores;

import java.util.Arrays;

public class MinorMatrix extends BaseMatrix {

    private int[] indexes;

    public MinorMatrix(IMatrix matrix, int[] indexes) {
        super(matrix);
        this.indexes = indexes;
    }

    @Override
    public Number getElement(int i, int j) {
        if(i >= wrapper.getN() || j >= wrapper.getN())
            return null;
        if(i < 0 || j < 0)
            return null;
        if(indexes.length == 0)
            return null;
        if(indexes.length >= wrapper.getN())
            return null;
        if(indexes[i] >= wrapper.getN() || indexes[i] < 0)
            return null;
        if(indexes[j] >= wrapper.getN() || indexes[j] < 0)
            return null;
        return wrapper.getElement(indexes[i], indexes[j]);
    }

    @Override
    public int getN() {
        if(indexes.length >= wrapper.getN())
            return -1;
        return indexes.length;
    }

    @Override
    public void setElement(Number value, int i, int j) {
        wrapper.setElement(value,indexes[i], indexes[j]);
    }

}
