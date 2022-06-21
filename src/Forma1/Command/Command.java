package Forma1.Command;

public abstract class Command {
    protected String[] input;

    public abstract boolean executable(String previousCommand);

    public abstract void execute(String[] input);

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }

}
