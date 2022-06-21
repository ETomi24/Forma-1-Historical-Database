package Forma1.Command;

import Forma1.DatabaseSingleton;
import Forma1.PointCalculationStrategy.*;

public class PointCommand extends Command {

    private PointCalculationStrategy pointCalculationStrategy;

    private PointCalculationStrategy getStrategy(String strategy){
        switch (strategy) {
            case "NEW" : return new New();
            case "MODERN" : return new Modern();
            case "CLASSIC" : return new Classic();
            case "PRESENT" : return new Present();
            default : return null;
        }
    }

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("QUERY")) {
            return true;
        }
        System.out.print("You can't give Point Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute(String[] input) {
        int year = DatabaseSingleton.getInstance().getQueriedYear();
        PointCalculationStrategy Strategy = this.getStrategy(input[1]);
        if(DatabaseSingleton.getInstance().getDatabase().containsKey(year)){
            DatabaseSingleton.getInstance().getDatabase().get(year).setCalculationStrategy(Strategy);
            DatabaseSingleton.getInstance().getDatabase().get(year).printStandings();
        }else{
            System.out.println("Sorry we dont have data from this year : " + DatabaseSingleton.getInstance().getQueriedYear());
        }

    }
}
