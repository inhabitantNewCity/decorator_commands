package test.commands;

import junit.framework.TestCase;
import main.commands.CommandManager;
import main.commands.TransposeCommand;
import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vlan0416 on 11.05.2018.
 */
public class TransposeCommandTest extends TestCase {

    IMatrix matrix;
    CommandManager commandManager = CommandManager.getInstance();


    @Before
    public void setUp() throws Exception {
        super.setUp();
        Number[][] elements = {{1,2,3}, {3,1,2}, {2,1,3}};
        matrix = new BaseMatrix(elements);
    }

    @Test
    public void testExecute() throws Exception {
        new TransposeCommand(commandManager, matrix).execute();
        assertEquals(2,matrix.getElement(0,2));
    }

    @Test
    public void testCopy() throws Exception {
        new TransposeCommand(commandManager, matrix).copy();
        assertEquals(3,matrix.getElement(0,2));
    }

}