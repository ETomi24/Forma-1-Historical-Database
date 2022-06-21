package Forma1.Command;

public class PointCommand extends Command {
    @Override
    public boolean executable(String previousCommand) {
        if (previousCommand.equals("QUERY")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String[] input) {

    }
}
