package main.commands;

import main.decoratores.IMatrix;
import main.decoratores.MultiplyConstMatrix;

public class MultipleCommand extends InitCommand {

    private float c;

    public MultipleCommand(IMatrix matrix, float c) {
        super(matrix);
        this.c = c;
    }

    @Override
    protected void undo() {
        matrix = new MultiplyConstMatrix(matrix, 1.0f/c);
    }

    @Override
    public void execute() {
        sing();
        matrix = new MultiplyConstMatrix(matrix, c);
    }

    @Override
    public ICommand copy() {
        return new MultipleCommand(matrix, c);
    }
}
