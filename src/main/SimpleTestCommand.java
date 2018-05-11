package main;

import main.commands.*;
import main.decoratores.BaseMatrix;
import main.decoratores.IMatrix;

/**
 * Created by vlan0416 on 11.05.2018.
 */
public class SimpleTestCommand {
    public static void main(String[] args) {
        Number[][] elements = {{1.0f,2.0f,3.0f}, {3.0f,1.0f,2.0f}, {2.0f,1.0f,3.0f}};

        IMatrix matrix = new BaseMatrix(elements);
        printMatrix(matrix);

        CommandManager commandManager = CommandManager.getInstance();

        new SetElementCommand(commandManager, matrix, 10.0f, 0, 1).execute();
        printMatrix(matrix);

        new SetElementCommand(commandManager, matrix, 7.0f, 1, 1).execute();
        printMatrix(matrix);

        ICommand command = new MultipleCommand(commandManager, matrix, 2);
        command.execute();
        printMatrix(matrix);

        new SetElementCommand(commandManager, matrix, 9.0f, 2, 1).execute();
        printMatrix(matrix);

        new TransponseCommand(commandManager, matrix).execute();
        printMatrix(matrix);

        commandManager.undoCommand(command);
        printMatrix(matrix);

        commandManager.rollback();
        printMatrix(matrix);

    }

    public static void printMatrix(IMatrix m){
        for(int i = 0; i < m.getN(); i++){
            for(int j = 0; j < m.getN(); j++){
                System.out.print(m.getElement(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
