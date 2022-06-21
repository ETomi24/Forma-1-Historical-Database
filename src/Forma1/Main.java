package Forma1;

import Forma1.Command.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static boolean validateMultiplier(double value) {
        if (value == 0.0) {
            return true;
        }
        if (value == 0.5) {
            return true;
        }
        if (value == 1.0) {
            return true;
        }
        if (value == 2.0) {
            return true;
        }
        return false;
    }

    public static boolean validCommand(String[] commandLine, String previousCommand) {
        Command command;
        switch (commandLine[0]) {
            case "RACE":

                command = new RaceCommand();
                return command.executable(previousCommand);

            case "FASTEST":

                command = new FastestCommand();
                return command.executable(previousCommand);

            case "RESULT":

                command = new ResultCommand();
                return command.executable(previousCommand);

            case "FINISH":

                command = new FinishCommand();
                return command.executable(previousCommand);

            case "QUERY":

                command = new QueryCommand();
                return command.executable(previousCommand);

            case "POINT":

                command = new PointCommand();
                return command.executable(previousCommand);

            default:
                return false;
        }
    }

    public static void executeCommand(String[] commandLine) {
        Command command;
        switch (commandLine[0]) {
            case "RACE":

                command = new RaceCommand();
                command.execute(commandLine);
                break;

            case "FASTEST":

                command = new FastestCommand();
                command.execute(commandLine);
                break;

            case "RESULT":

                command = new ResultCommand();
                command.execute(commandLine);
                break;

            case "FINISH":

                command = new FinishCommand();
                command.execute(commandLine);
                break;

            case "QUERY":

                command = new QueryCommand();
                command.execute(commandLine);
                break;

            case "POINT":

                command = new PointCommand();
                command.execute(commandLine);
                break;

            default:
        }
    }

    public static void readFile(String fileName) {

        File file = new File(fileName);

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
             BufferedReader reader = new BufferedReader(isr)
        ) {

            String inputLine;
            String previousCommand = "FINISH";
            while (!Objects.equals(inputLine = reader.readLine(), "EXIT")) {
                if (!inputLine.isEmpty()) {
                    String[] inputStringTrimmed = inputLine.split(";", 0);
                    boolean ok = validCommand(inputStringTrimmed, previousCommand);
                    executeCommand(inputStringTrimmed);
                    System.out.println(Arrays.toString(inputStringTrimmed));
                    System.out.println(ok);
                    previousCommand = inputStringTrimmed[0];
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        DatabaseSingleton.getInstance();
        readFile("input-hf.txt");
        System.out.println(DatabaseSingleton.getInstance().getDatabase().toString());
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
    }
}
