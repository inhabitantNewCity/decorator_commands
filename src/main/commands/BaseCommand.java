package main.commands;

import main.decoratores.IMatrix;

public class BaseCommand implements ICommand {
    protected CommandManager manager;
    protected IMatrix matrix;

    protected void undo(){

    }

    protected void sing(){
        manager.sing(this);
    }

    public BaseCommand(IMatrix matrix, CommandManager manager){
        this.matrix = matrix;
        this.manager = manager;
    }
    public BaseCommand(CommandManager manager){
        this.manager = manager;
    }

    @Override
    public void execute() {
       sing();
    }

    @Override
    public ICommand copy() {
        return new BaseCommand(matrix, manager);
    }
}
