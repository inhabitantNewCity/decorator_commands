package main.commands;

import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;

public class MultipleCommand extends BaseCommand {

    private float c;
    private IMatrix prevState;

    public MultipleCommand(CommandManager manager,IMatrix matrix, float c) {
        super(matrix, manager);
        this.c = c;
        prevState = ((BaseMatrix) matrix).copy();
    }

    @Override
    protected void undo() {
        for(int i= 0; i<matrix.getN();i++)
            for(int j=0;j<matrix.getN();j++)
                matrix.setElement(prevState.getElement(i, j), i, j);
    }

    @Override
    public void execute() {
        sing();
        for(int i= 0; i<matrix.getN();i++)
            for(int j=0;j<matrix.getN();j++)
                matrix.setElement(prevState.getElement(i, j).floatValue() * c, i, j);
    }

    @Override
    public ICommand copy() {
        return new MultipleCommand(manager, matrix, c);
    }
}
