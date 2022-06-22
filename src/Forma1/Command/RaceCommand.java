package Forma1.Command;

import Forma1.DatabaseSingleton;
import Forma1.Model.Race;

public class RaceCommand extends Command {

    private boolean validateMultiplier(double value) {
        if (value == 0.0) {
            return true;
        }
        if (value == 0.5) {
            return true;
        }
        if (value == 1.0) {
            return true;
        }
        if (value == 2.0) {
            return true;
        }
        System.out.print("Multiplier value not correct at RACE COMMAND choose from these values [0, 1, 0.5 ,2]");
        return false;
    }

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("FINISH") || previousCommand.equals("POINT") || previousCommand.equals("Nothing")) {
            if (argumentsLengthCheck(5 , "RACE")){
                double value = Double.parseDouble(input[4]);
                return validateMultiplier(value);
            } else { return false;}
        }
        System.out.print("You can't give Race Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute() {
        int year = Integer.parseInt(input[1]);
        if (DatabaseSingleton.getInstance().getDatabase().get(year) == null){
            DatabaseSingleton.getInstance().addYear(year);
        }
        Race race = new Race(year, input[2], Integer.parseInt(input[3]), Double.parseDouble(input[4]));
        DatabaseSingleton.getInstance().getDatabase().get(year).addRace(race);
        DatabaseSingleton.getInstance().setActualRace(race);
    }


}
