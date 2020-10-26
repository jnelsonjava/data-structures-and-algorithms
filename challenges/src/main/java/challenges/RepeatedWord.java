package challenges;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class RepeatedWord {

    public static String findFirstRepeatWord(String str) {
        // reference for multiple delimiters in regex split https://stackoverflow.com/questions/5993779/use-string-split-with-multiple-delimiters
        String[] splitStr = str.toLowerCase().split("\\W+");
        HashSet<String> wordBucket = new HashSet<>();
        for (String word : splitStr) {
            if (!wordBucket.add(word)) {
                return word;
            }
        }

        throw new NoSuchElementException("No duplicate words found");
    }
}
