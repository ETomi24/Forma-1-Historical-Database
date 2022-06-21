package Forma1.Model;

import Forma1.PointCalculationStrategy.PointCalculationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Year {
    private List<Race> raceList;
    private Map<String, Integer> driverStandings;
    private Map<String, Integer> constructorStandings;
    private PointCalculationStrategy calculationStrategy;


    public Year() {
        this.raceList = new ArrayList<Race>();
        this.driverStandings = new HashMap<>();
        this.constructorStandings = new HashMap<>();
    }

    public void addRace(Race race) {
        raceList.add(race);
    }

    public List<Race> getRaceList() {
        return raceList;
    }

    public Map<String, Integer> getDriverStandings() {
        return driverStandings;
    }

    public Map<String, Integer> getConstructorStandings() {
        return constructorStandings;
    }

    public PointCalculationStrategy getCalculationStrategy() {
        return calculationStrategy;
    }

    public void setCalculationStrategy(PointCalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    @Override
    public String toString() {
        return "Year{" +
                "raceList=" + raceList +
                ", driverStandings=" + driverStandings +
                ", constructorStandings=" + constructorStandings +
                ", calculationStrategy=" + calculationStrategy +
                '}';
    }
}
