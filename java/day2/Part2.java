import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("part2.txt"));
            if ( allLines != null && !allLines.isEmpty() ) {
                long answer = solve(allLines);
                System.out.println("Solution is ::: " + answer);
            }
        } catch( IOException ex ) {
            ex.printStackTrace();
        }
    }

    public static long solve(List<String> inputLines) {
        long sum = 0L;
        for ( String line : inputLines ) {
            Long minGreenBallsRequired = 0L, minBlueBallsRequired = 0L, minRedBallsRequired = 0L;
            // extract the game id part first
            // the game id is the LHS of the string that we obtain by calling split with :
            String[] parts = line.split(":");
            String gameID = parts[0].split(" ")[1];
            System.out.println("Extracted game ID is :: " + gameID);
            // The combinations part is the second element in the parts array
            // we need to extract all possible combinations within that array
            // split by semicolon to find out all possible combinations
            String[] allPossibleGameCombinations = parts[1].trim().split(";");
            for ( String elem : allPossibleGameCombinations ) {
                // System.out.println(elem.trim());
                String[] ballCount = elem.trim().split(",");
                System.out.println("size of array after splitting is " + ballCount.length);
                for (String countElement : ballCount) {
                    System.out.println(countElement.trim());
                    String[] countParts = countElement.trim().split(" ");
                    switch( countParts[1].trim() ) { 
                        case "blue":
                            if (Long.parseLong(countParts[0]) > minBlueBallsRequired) {
                                minBlueBallsRequired = Long.parseLong(countParts[0]);
                            }
                            break;
                        case "green": 
                            if (Long.parseLong(countParts[0]) > minGreenBallsRequired) {
                                minGreenBallsRequired = Long.parseLong(countParts[0]);
                            }
                            break;
                        case "red": 
                            if (Long.parseLong(countParts[0]) > minRedBallsRequired ) {
                                minRedBallsRequired = Long.parseLong(countParts[0]);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            sum += (minRedBallsRequired * minBlueBallsRequired * minGreenBallsRequired);
        }
        return sum;
    }
}
