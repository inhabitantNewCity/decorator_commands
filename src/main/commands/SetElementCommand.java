package main.commands;

import main.decoratores.IMatrix;

public class SetElementCommand extends InitCommand {

    private Number value;
    private Number prevValue;
    private int i;
    private int j;

    public SetElementCommand(IMatrix matrix, Number value, int i, int j) {
        super(matrix);
        this.value = value;
        this.prevValue = matrix.getElement(i,j);
        this.i = i;
        this.j = j;
    }

    @Override
    protected void undo() {
        matrix.setElement(prevValue, i, j);
    }

    @Override
    public void execute() {
        sing();
        matrix.setElement(value, i, j);
    }

    @Override
    public ICommand copy() {
        return new SetElementCommand(matrix, value,i,j);
    }
}
