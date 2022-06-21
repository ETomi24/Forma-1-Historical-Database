package Forma1.PointCalculationStrategy;

import Forma1.Model.Race;
import Forma1.Model.Year;

import java.util.ArrayList;
import java.util.List;

public class Present implements PointCalculationStrategy {
    private final List<Integer> multipliers = new ArrayList<>();

    public Present() {
        multipliers.add(25);
        multipliers.add(18);
        multipliers.add(15);
        multipliers.add(12);
        multipliers.add(10);
        multipliers.add(8);
        multipliers.add(6);
        multipliers.add(4);
        multipliers.add(2);
        multipliers.add(1);
    }

    @Override
    public void calculate(Year year) {
        for (Race race : year.getRaceList()) {
            for (int i = 0; i < 10; i++) {
                if (!year.getDriverStandings().containsKey(race.getResultList().get(i).getName())){
                    year.getDriverStandings().put(race.getResultList().get(i).getName(),0.0);
                }
                double oldValue = year.getDriverStandings().get(race.getResultList().get(i).getName());
                double newValue = oldValue + (multipliers.get(i) * race.getPointsMultiplier());
                year.getDriverStandings().put(race.getResultList().get(i).getName(),newValue);
            }
            if (race.getFastestLap().getValid()){
                double oldValue = year.getDriverStandings().get(race.getFastestLap().getName());
                double newValue = oldValue + 1;
                year.getDriverStandings().put(race.getFastestLap().getName(),newValue);
            }

        }
    }
}
