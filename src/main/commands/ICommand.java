package main.commands;

public interface ICommand {
    void execute();
    ICommand copy();   
}
