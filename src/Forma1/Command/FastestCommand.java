package Forma1.Command;


import Forma1.DatabaseSingleton;
import Forma1.Model.FastestLap;

public class FastestCommand extends Command {

    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("RESULT")) {
            return true;
        }
        System.out.print("You can't give Fastest Command because previous Command was " + previousCommand);
        return false;
    }

    @Override
    public void execute(String[] input) {
        FastestLap fastestLap = new FastestLap(input[1], input[2]);
        DatabaseSingleton.getInstance().getActualRace().setFastestLap(fastestLap);
    }

}
