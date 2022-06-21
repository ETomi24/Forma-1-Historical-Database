package Forma1;

import Forma1.Model.Race;
import Forma1.Model.Year;

import java.util.HashMap;
import java.util.Map;

public class DatabaseSingleton {
    private static DatabaseSingleton instance = null;

    private Map<Integer, Year> database;

    private Race actualRace;
    private int queriedYear;
    private int queriedRace;

    private DatabaseSingleton() {
        this.database = new HashMap<>();
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null)
            instance = new DatabaseSingleton();

        return instance;
    }

    public void addYear(Integer year) {
        database.put(year, new Year());
    }


    public Race getActualRace() {
        return actualRace;
    }

    public void setActualRace(Race actualRace) {
        this.actualRace = actualRace;
    }

    public int getQueriedYear() {
        return queriedYear;
    }

    public void setQueriedYear(int queriedYear) {
        this.queriedYear = queriedYear;
    }

    public int getQueriedRace() {
        return queriedRace;
    }

    public void setQueriedRace(int queriedRace) {
        this.queriedRace = queriedRace;
    }

    public Map<Integer, Year> getDatabase() {
        return database;
    }

    @Override
    public String toString() {
        return "DatabaseSingleton{" +
                "database=" + database.toString() +
                '}';
    }

}
