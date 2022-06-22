package Forma1.Command;

import Forma1.DatabaseSingleton;

public class QueryCommand extends Command {
    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("POINT") || previousCommand.equals("FINISH") || previousCommand.equals("Nothing")) {
            return argumentsLengthCheck(2, "QUERY");
        }
        System.out.print("You can't give QUERY Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute() {
        int year = Integer.parseInt(input[1]);
        if(input.length == 2){
            DatabaseSingleton.getInstance().setQueriedYear(year);
        }
        if(input.length == 3){
            int race = Integer.parseInt(input[2]);
            DatabaseSingleton.getInstance().setQueriedYear(year);
            DatabaseSingleton.getInstance().setQueriedRace(race);
        }
    }


}
