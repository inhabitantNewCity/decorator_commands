package main.decoratores;

public interface IMatrix {
    Number getElement(int i, int j);
    int getN();
    void setElement(Number value, int i, int j);

    // using only in Decorator Pattern
    IMatrix revertOperation();
}
