package main.decoratores;

public class ZeroElementsMatrix extends BaseMatrix {

    public ZeroElementsMatrix(IMatrix matrix) {
        super(matrix);
    }

    @Override
    public Number getElement(int i, int j) {
        if(i < j)
            return 0;
        return wrapper.getElement(i, j);
    }

    @Override
    public int getN() {
        return wrapper.getN();
    }

    @Override
    public void setElement(Number value, int i, int j) {
        if(i >= j)
            wrapper.setElement(value, i, j);
    }

}
