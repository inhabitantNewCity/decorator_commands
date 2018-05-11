package test.commands;

import junit.framework.TestCase;
import main.UnregisteredCommandException;
import main.commands.*;
import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vlan0416 on 11.05.2018.
 */
public class CommandManagerTest extends TestCase {

    IMatrix matrix;
    CommandManager commandManager = CommandManager.getInstance();


    @Before
    public void setUp() throws Exception {
        super.setUp();
        Number[][] elements = {{1.0f,2.0f,3.0f}, {3.0f,1.0f,2.0f}, {2.0f,1.0f,3.0f}};
        matrix = new BaseMatrix(elements);
    }

    @Test
    public void testRollbackSimple() throws Exception {
        new TransposeCommand(commandManager, matrix).execute();
        commandManager.rollback();
        assertEquals(3.0f,matrix.getElement(0,2));
    }

    @Test
    public void testRollback() throws Exception {
        new SetElementCommand(commandManager, matrix, 10.0f, 0, 1).execute();
        new SetElementCommand(commandManager, matrix, 7.0f, 1, 1).execute();
        new MultipleCommand(commandManager, matrix, 2).execute();
        new SetElementCommand(commandManager, matrix, 9.0f, 2, 1).execute();
        new TransposeCommand(commandManager, matrix).execute();

        commandManager.rollback();
        assertEquals(3.0f,matrix.getElement(0,2));
    }

    @Test
    public void testUndoCommandSimple() throws Exception {
        ICommand command = new TransposeCommand(commandManager, matrix);
        command.execute();
        commandManager.undoCommand(command);

        assertEquals(3.0f,matrix.getElement(0,2));
    }

    @Test
    public void testUndoCommandUnregistered() throws Exception {
        ICommand command = new TransposeCommand(commandManager, matrix);
        try {
            commandManager.undoCommand(command);
            fail("Command is not found");
        } catch(UnregisteredCommandException e) {
            //if execution reaches here,
            //it indicates this exception was occured.
            //so we need not handle it.
        }
    }

    @Test
    public void testUndoCommand() throws Exception {
        new SetElementCommand(commandManager, matrix, 10.0f, 0, 1).execute();
        new SetElementCommand(commandManager, matrix, 7.0f, 1, 1).execute();

        ICommand command = new MultipleCommand(commandManager, matrix, 2);
        command.execute();

        new SetElementCommand(commandManager, matrix, 9.0f, 2, 1).execute();
        new TransposeCommand(commandManager, matrix).execute();

        commandManager.undoCommand(command);
        assertEquals(10.0f,matrix.getElement(0,1));
    }

    @Test
    public void testUndoRollbackCommand() throws Exception {
        new SetElementCommand(commandManager, matrix, 10.0f, 0, 1).execute();
        new SetElementCommand(commandManager, matrix, 7.0f, 1, 1).execute();

        ICommand command = new MultipleCommand(commandManager, matrix, 2);
        command.execute();

        new SetElementCommand(commandManager, matrix, 9.0f, 2, 1).execute();
        new TransposeCommand(commandManager, matrix).execute();

        commandManager.undoCommand(command);
        commandManager.rollback();
        assertEquals(2.0f,matrix.getElement(0,1));
    }

}