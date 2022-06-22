package Forma1.Model;

import Forma1.DatabaseSingleton;
import Forma1.PointCalculationStrategy.PointCalculationStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Year {
    private List<Race> raceList;
    private Map<String, Double> driverStandings;
    private Map<String, Double> constructorStandings;
    private PointCalculationStrategy calculationStrategy;


    public Year() {
        this.raceList = new ArrayList<Race>();
        this.driverStandings = new HashMap<>();
        this.constructorStandings = new HashMap<>();
    }

    public void addRace(Race race) {
        raceList.add(race);
        raceList.sort(Comparator.comparing(Race::getRaceCounter));
    }

    public List<Race> getRaceList() {
        return raceList;
    }

    public Map<String, Double> getDriverStandings() {
        return driverStandings;
    }

    public Map<String, Double> getConstructorStandings() {
        return constructorStandings;
    }

    public PointCalculationStrategy getCalculationStrategy() {
        return calculationStrategy;
    }

    public void setCalculationStrategy(PointCalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public void printStandings(int countTo) {
        if(calculationStrategy == null) {
            System.out.println("PointCalculation is missing " + DatabaseSingleton.getInstance().getQueriedYear());
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(DatabaseSingleton.getInstance().getQueriedYear() + " year WORLD RANKING");


        //inicializálás
        driverStandings = new HashMap<>();
        for (Result result : raceList.get(0).getResultList()){
                driverStandings.put(result.getName(), 0.0);
        }

        //számítás
        calculationStrategy.calculate(this , countTo);

        //rendezés
        driverStandings = driverStandings.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        //kiíratás
        int position = 1;
        for (Map.Entry<String, Double> entry : driverStandings.entrySet()) {
            System.out.println(position + " " +entry.getKey() + " : " + entry.getValue() + " point");
            position++;
        }
        System.out.println("-----------------------------------------------------------------------");

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
