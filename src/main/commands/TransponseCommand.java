package main.commands;

import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;

public class TransponseCommand extends BaseCommand {

    private IMatrix prevState;

    public TransponseCommand(CommandManager manager, IMatrix matrix) {
        super(matrix, manager);
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
                matrix.setElement(prevState.getElement(i, j), j, i);
    }

    @Override
    public ICommand copy() {
        return new TransponseCommand(manager, matrix);
    }
}
