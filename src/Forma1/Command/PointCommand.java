package Forma1.Command;

import Forma1.DatabaseSingleton;
import Forma1.PointCalculationStrategy.*;

public class PointCommand extends Command {

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
            return argumentsLengthCheck(2, "POINT");
        }
        System.out.print("You can't give Point Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute() {
        int year = DatabaseSingleton.getInstance().getQueriedYear();
        PointCalculationStrategy Strategy = this.getStrategy(input[1]);
        if(DatabaseSingleton.getInstance().getDatabase().containsKey(year)){
            DatabaseSingleton.getInstance().getDatabase().get(year).setCalculationStrategy(Strategy);
            if(DatabaseSingleton.getInstance().getQueriedRace()!= -1) {
                int countTo = DatabaseSingleton.getInstance().getQueriedRace();
                DatabaseSingleton.getInstance().getDatabase().get(year).printStandings(countTo);
            }else{
                DatabaseSingleton.getInstance().getDatabase().get(year).printStandings(Integer.MAX_VALUE);
            }

            DatabaseSingleton.getInstance().setQueriedRace(-1);
            DatabaseSingleton.getInstance().setQueriedYear(-1);
        }else{
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(DatabaseSingleton.getInstance().getQueriedYear() + " year WORLD RANKING");
            System.out.println("Sorry we dont have data from this year : " + DatabaseSingleton.getInstance().getQueriedYear());
            System.out.println("-----------------------------------------------------------------------");
        }

    }
}
