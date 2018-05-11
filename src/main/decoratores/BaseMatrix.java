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

    //command reasons
    public IMatrix copy(){
        Number[][] clone = new Number[matrix.length][matrix.length];
        for(int i = 0; i < clone.length; i++){
            for(int j=0;j<clone[i].length; j++)
                clone[i][j] = matrix[i][j];
        }
        return new BaseMatrix(clone);
    }
}
