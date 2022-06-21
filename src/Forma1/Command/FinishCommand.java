package Forma1.Command;

import Forma1.DatabaseSingleton;

public class FinishCommand extends Command {
    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("RESULT") || previousCommand.equals("FASTEST")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String[] input) {
        DatabaseSingleton.getInstance().setActualRace(null);
    }

}
