package Forma1.Command;

import Forma1.DatabaseSingleton;

public class FinishCommand extends Command {

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("RESULT") || previousCommand.equals("FASTEST")) {
            return true;
        }
        System.out.print("You can't give Finish Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute(String[] input) {
        DatabaseSingleton.getInstance().setActualRace(null);
    }

}
