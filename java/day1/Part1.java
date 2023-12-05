import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("part1.txt"));
        int sum = 0;
        List<Character> digits = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        for ( String line : allLines) {
            Integer firstDigit=null, lastDigit=null;
            Integer lineSum = 0;
            for ( char c : line.toCharArray() ) {
                if ( digits.contains(c) ) {
                    Integer parsed  = Integer.parseInt(new String(new char[]{c}));
                    if ( firstDigit == null ) {
                        firstDigit = parsed;
                    }
                    lastDigit = parsed;
                }
            }
            lineSum = (firstDigit * 10) + lastDigit;
            sum += lineSum;
        }
        System.out.println("Answer ::: " + sum);
    }
}
