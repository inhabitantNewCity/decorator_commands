package main.commands;

import java.util.ArrayList;

public class CommandManager {

    private static CommandManager instance;
    private ArrayList<ICommand> commands = new ArrayList<ICommand>();

    private CommandManager(){};
    public static CommandManager getInstance(){
        return instance != null?instance:new CommandManager();
    }

    public void sing(ICommand command){
       commands.add(command);
    }

    public void rollback(){
        //TODO: undo all operation and get undo method form ICommand
    }

    public void undoCommand(ICommand command){
       //TODO: undo all operation and execute operation before 'command'
    }
}
