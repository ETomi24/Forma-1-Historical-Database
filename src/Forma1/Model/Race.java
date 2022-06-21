package Forma1.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private final int year;
    private final String name;
    private final int raceCounter;
    private final double pointsMultiplier;
    private FastestLap fastestLap;
    private List<Result> resultList;

    public Race(int year, String name, int raceCounter, double pointsMultiplier) {
        this.year = year;
        this.name = name;
        this.raceCounter = raceCounter;
        this.pointsMultiplier = pointsMultiplier;
        this.resultList = new ArrayList<Result>();
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public double getPointsMultiplier() {
        return pointsMultiplier;
    }

    public int getRaceCounter() {
        return raceCounter;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void addResult(Result result) {
        resultList.add(result);
        resultList.sort(Comparator.comparing(Result::getPosition));
    }

    public FastestLap getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(FastestLap fastestLap) {
        this.fastestLap = fastestLap;
    }

    @Override
    public String toString() {
        return "Race{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", raceCounter=" + raceCounter +
                ", pointsMultiplier=" + pointsMultiplier +
                ", fastestLap='" + fastestLap + '\'' +
                ", resultList=" + resultList +
                '}';
    }


}
