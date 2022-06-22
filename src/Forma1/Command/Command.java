package Forma1.Command;

public abstract class Command {
    protected String[] input;

    public abstract boolean executable(String previousCommand);

    public abstract void execute();

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }

    protected boolean argumentsLengthCheck(int minSize, String name) {
        if(this.getInput() != null){
            if(minSize > input.length){
                System.out.print("You have less argument than allowed at " +name+ " Command. You have to give at least " + (minSize-1) + " argument");
                return false;
            }
            return true;
        }
        System.out.print("You have less argument than allowed at " +name+ "Command. You have to give at least " + (minSize-1) + " argument");
        return false;
    }

}
