package Forma1.Command;

import Forma1.DatabaseSingleton;
import Forma1.Model.Race;

public class RaceCommand extends Command {

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("FINISH") || previousCommand.equals("POINT")) {
            return true;
        }
        System.out.print("You can't give Race Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute(String[] input) {
        int year = Integer.parseInt(input[1]);
        if (DatabaseSingleton.getInstance().getDatabase().get(year) == null){
            DatabaseSingleton.getInstance().addYear(year);
        }
        Race race = new Race(year, input[2], Integer.parseInt(input[3]), Double.parseDouble(input[4]));
        DatabaseSingleton.getInstance().getDatabase().get(year).addRace(race);
        DatabaseSingleton.getInstance().setActualRace(race);
    }


}
