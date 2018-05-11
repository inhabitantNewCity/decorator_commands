package main.commands;

import main.decoratores.IMatrix;
import main.decoratores.TransportMatrix;

public class TransponseCommand extends  InitCommand {

    public TransponseCommand(IMatrix matrix) {
        super(matrix);
    }

    @Override
    protected void undo() {
        matrix = new TransportMatrix(matrix);
    }

    @Override
    public void execute() {
        sing();
        matrix = new TransportMatrix(matrix);
    }

    @Override
    public ICommand copy() {
        return new TransponseCommand(matrix);
    }
}
