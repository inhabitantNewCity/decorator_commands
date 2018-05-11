package main.commands;

import main.UnregistratedCommandException;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;


public class CommandManager {

    private static CommandManager instance;
    private volatile AtomicBoolean locked = new AtomicBoolean(false);
    private Deque<BaseCommand> commands = new ConcurrentLinkedDeque<>();

    private CommandManager(){
        commands.addLast(new BaseCommand(this));
    }
    public static CommandManager getInstance(){
        return instance != null?instance:new CommandManager();
    }

    public void sing(ICommand command){
       commands.addFirst((BaseCommand)command);
    }

    /**
     * Rollback current state to init state
     */
    public void rollback(){
        locked.set(true);
        commands.iterator().forEachRemaining(BaseCommand::undo);
        commands.clear();
        commands.addLast(new BaseCommand(this));
        locked.set(false);
    }

    /**
     * method execute undo for all operation in the system
     * execute operations before input command
     * @param command: current command
     */
    public void undoCommand(ICommand command){
        if (!commands.contains(command))
            throw new UnregistratedCommandException();
        if(commands.isEmpty())
            return;

        locked.set(true);
        BaseCommand currentCommand = commands.getLast();
        Deque<BaseCommand> currentCommands = new ConcurrentLinkedDeque<>();

        Iterator<BaseCommand> iterator = commands.descendingIterator();

        while(currentCommand !=  command){
            currentCommands.addLast(currentCommand);
            currentCommand = iterator.next();
        }

        rollback();
        currentCommands.iterator().forEachRemaining(BaseCommand::execute);
        locked.set(false);
    }
}
