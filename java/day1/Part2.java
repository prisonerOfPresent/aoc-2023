import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("part2.txt"));
        int sum = 0;
        List<Character> digits = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        List<String> numberWords = Arrays.asList("one","two","three",
                "four","five","six","seven","eight","nine");
        for ( String line : allLines ) {
            Integer firstDigit=null, lastDigit=null;
            Integer firstDigitIndex = -1, lastDigitIndex = -1;
            Integer lineSum = 0;
            char[] charsInLine = line.toCharArray();
            for ( int i=0; i< line.length(); i++ ) {
                char c = charsInLine[i];
                if ( digits.contains(c) ) {
                    Integer parsed  = Integer.parseInt(new String(new char[]{c}));
                    if ( firstDigit == null ) {
                        firstDigit = parsed;
                        firstDigitIndex = i;
                    }
                    lastDigit = parsed;
                    lastDigitIndex = i;
                }
            }
            // now we need to iterate over all substrings
            // and check if we are finding any words which describe numbers
            for ( int i=0; i<line.length(); i++  ) {
                for ( int j=i+1; j< line.length(); j++ ) {
                    String subString = line.substring(i,j+1);
                    if ( numberWords.contains(subString) ) {
                        Integer parsed = null;
                        switch( subString ) {
                            case "one": parsed = 1;break;
                            case "two": parsed = 2; break;
                            case "three": parsed =3;break;
                            case "four": parsed=4; break;
                            case "five": parsed =5; break;
                            case "six": parsed = 6; break;
                            case "seven": parsed = 7; break;
                            case "eight" : parsed = 8; break;
                            case "nine": parsed = 9; break;
                            default: break;
                        }
                        if ( firstDigitIndex < 0 ||  firstDigitIndex > i ) {
                            firstDigitIndex = i;
                            firstDigit = parsed;
                        }
                        if ( lastDigit == null || lastDigitIndex < i  ) {
                            lastDigit = parsed;
                            lastDigitIndex = i;
                        }
                    }
                }
            }
            lineSum = (firstDigit * 10) + lastDigit;
            sum += lineSum;
        }
        System.out.println("Answer ::: " + sum);
    }
}
