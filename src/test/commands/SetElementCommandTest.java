package test.commands;

import main.commands.CommandManager;
import main.commands.SetElementCommand;
import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vlan0416 on 11.05.2018.
 */
public class SetElementCommandTest {

    @Test
    public void testExecute() throws Exception {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        CommandManager commandManager = CommandManager.getInstance();
        new SetElementCommand(commandManager, matrix, 2, 0, 2).execute();

        assertEquals(2,matrix.getElement(0,2));
    }

    @Test
    public void testCopy() throws Exception {
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        IMatrix matrix = new BaseMatrix(elements);
        CommandManager commandManager = CommandManager.getInstance();
        new SetElementCommand(commandManager, matrix, 2, 0, 2).copy();

        assertEquals(3,matrix.getElement(0,2));
    }

}