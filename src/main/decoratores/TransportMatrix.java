package main.decoratores;

public class TransportMatrix extends BaseMatrix {

    public TransportMatrix(IMatrix matrix) {
        super(matrix);
    }

    @Override
    public Number getElement(int i, int j) {
        return wrapper.getElement(j, i);
    }

    @Override
    public int getN() {
        return wrapper.getN();
    }

    @Override
    public void setElement(Number value, int i, int j) {
        wrapper.setElement(value,j,i);
    }

}
