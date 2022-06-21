package Forma1.Model;

public class Result {
    private final int position;
    private final String name;
    private final String team;

    public Result(int position, String name, String team) {
        this.position = position;
        this.name = name;
        this.team = team;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Result{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
