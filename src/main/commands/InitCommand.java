package main.commands;

import main.decoratores.IMatrix;

public class InitCommand implements ICommand {
    private CommandManager manager;
    protected IMatrix matrix;

    protected void undo(){

    }

    protected void sing(){
        manager.sing(this);
    }

    public InitCommand(IMatrix matrix){
        this.matrix = matrix;
    }

    @Override
    public void execute() {
       sing();
    }

    @Override
    public ICommand copy() {
        return new InitCommand(matrix);
    }
}
