package Forma1.Command;

import Forma1.DatabaseSingleton;
import Forma1.Model.Result;

public class ResultCommand extends Command {

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("RACE") || previousCommand.equals("RESULT") || previousCommand.equals("FASTEST")) {
            return argumentsLengthCheck(4,"RESULT");
        }
        System.out.print("You can't give Result Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute() {
        Result result = new Result(Integer.parseInt(input[1]),input[2],input[3]);
        DatabaseSingleton.getInstance().getActualRace().addResult(result);
    }


}
