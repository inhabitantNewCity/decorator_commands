package main.decoratores;

public class BaseMatrix implements IMatrix {

    protected IMatrix wrapper;
    private Number[][] matrix;

    public BaseMatrix(IMatrix matrix){
        this.wrapper = matrix;
    }

    public BaseMatrix(Number[][] matrix){
        this.matrix = matrix;
    }

    @Override
    public Number getElement(int i, int j) {
        return matrix[i][j];
    }

    @Override
    public int getN() {
        return matrix.length;
    }

    @Override
    public void setElement(Number value, int i, int j) {
        matrix[i][j] = value;
    }

    @Override
    public IMatrix revertOperation() {
        return wrapper;
    }
}
