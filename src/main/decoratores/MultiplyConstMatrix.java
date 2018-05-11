package main.decoratores;

public class MultiplyConstMatrix extends BaseMatrix {

    private float c;

    public MultiplyConstMatrix(IMatrix matrix, float c) {
        super(matrix);
        this.c = c;
    }

    @Override
    public Number getElement(int i, int j) {
        return wrapper.getElement(j, i).intValue() * c;
    }

    @Override
    public int getN() {
        return wrapper.getN();
    }

    @Override
    public void setElement(Number value, int i, int j) {
        wrapper.setElement(value,j,i);
    }

    public float getConstatnt(){
        return c;
    }
}
