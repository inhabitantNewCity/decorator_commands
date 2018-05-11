package main.commands;

import main.decoratores.IMatrix;

public class SetElementCommand extends BaseCommand {

    private Number value;
    private Number prevValue;
    private int i;
    private int j;

    public SetElementCommand(CommandManager manager, IMatrix matrix, Number value, int i, int j) {
        super(matrix, manager);
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
        return new SetElementCommand(manager, matrix, value,i,j);
    }
}
