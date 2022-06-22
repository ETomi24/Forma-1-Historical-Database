package Forma1;

import Forma1.Command.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    //beolvassa a sorokat(Commandokat) és végrehajtja őket ha helyesek
    public static void readFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()){
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
                 BufferedReader reader = new BufferedReader(isr)
            ) {
                String inputLine;
                String previousCommand = "Nothing";
                int lineCounter = 1;
                while ((inputLine = reader.readLine()) != null) {
                    if (!inputLine.isEmpty()) {
                        String[] inputStringTrimmed = inputLine.split(";", 0);
                        if(!commands.containsKey(inputStringTrimmed[0])){
                            System.out.println("The " + inputStringTrimmed[0] + " it's not a correct COMMAND please choose from these [RACE,RESULT,FASTEST,FINISH,QUERY,POINT] [ERROR line : " + lineCounter + "]");
                        } else {
                            Command command = commands.get(inputStringTrimmed[0]);
                            command.setInput(inputStringTrimmed);
                            if(command.executable(previousCommand)){
                                command.execute();
                                previousCommand = inputStringTrimmed[0];
                            } else { System.out.println(" [ERROR line : " + lineCounter + "]") ; }
                        }
                        lineCounter++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("This file is not existing");
        }
    }

    static Map<String,Command> commands = new HashMap<>();

    public static void main(String[] args) {
        //commands init
        commands.put("RACE" , new RaceCommand());
        commands.put("RESULT" , new ResultCommand());
        commands.put("FASTEST" , new FastestCommand());
        commands.put("FINISH" , new FinishCommand());
        commands.put("QUERY" , new QueryCommand());
        commands.put("POINT" , new PointCommand());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me a file name or if you want to exit type 'CIAO'");
        String inputFromConsole;
        while (!Objects.equals(inputFromConsole = scanner.nextLine(), "CIAO")){
            if(!inputFromConsole.equals("CIAO")){
                readFile(inputFromConsole);
                DatabaseSingleton.getInstance().setDatabase(new HashMap<>());
                System.out.println("Please give me a file name or if you want to exit type 'CIAO'");
            }
        }
    }
}
