package Forma1.Model;

import java.util.List;

public class FastestLap {

    private final String name;
    private final String team;

    private boolean valid;


    public FastestLap(String name, String team) {
        this.name = name;
        this.team = team;
    }


    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(List<Result> results) {
        boolean validity = false;
        for (int i = 0; i < 10; i++) {
            //ha megegyezzik a neve és a csapatneve és az első tízben volt akkor számit a  leggyorsabb kör
            if (results.get(i).getName().equals(name) && results.get(i).getTeam().equals(team)) {
                validity = true;
            }
        }
        this.valid = validity;
    }

    @Override
    public String toString() {
        return "FastestLap{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", valid=" + valid +
                '}';
    }
}
