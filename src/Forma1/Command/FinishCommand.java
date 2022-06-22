package Forma1.Command;

import Forma1.DatabaseSingleton;

public class FinishCommand extends Command {

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("RESULT") || previousCommand.equals("FASTEST")) {
            int size = DatabaseSingleton.getInstance().getActualRace().getResultList().size();
            if(size >= 10 ){
                return true;
            } else {
                System.out.print("You have to add "+ (10-size) + " more result to the race to FINISH it");
                return false;
            }

        }
        System.out.print("You can't give Finish Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute(String[] input) {
        DatabaseSingleton.getInstance().setActualRace(null);
    }

}
