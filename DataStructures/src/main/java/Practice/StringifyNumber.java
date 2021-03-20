package Practice;

import java.util.HashMap;
import java.util.Map;

public class StringifyNumber {
    private static final Map<Integer, String> subTwentyMap = buildSubTwentyMap();
    private static final Map<Integer, String> subOneHundredMap = buildSubOneHundredMap();
    private static final int[] numKeys = {1000000000, 1000000, 1000, 100};
    private static final String[] numStrings = {"billion", "million", "thousand", "hundred"};

    public static String numberAsSpoken(int num) {
        if (num == 0) return "zero";

        if (num < 20) return subTwentyMap.get(num);

        if (num < 100) {
            StringBuilder strBuild = new StringBuilder();
            strBuild.append(subOneHundredMap.get(num / 10));
            if (num % 10 > 0) {
                strBuild.append(' ');
                strBuild.append(numberAsSpoken(num % 10));
            }
            return strBuild.toString();
        }

        StringBuilder strBuild = new StringBuilder();
        while (num >= 100) {
            for (int i = 0; i < numKeys.length; i++) {
                int checkNum = numKeys[i];
                if (num / checkNum > 0) {
                    if (strBuild.length() > 0) strBuild.append(' ');
                    strBuild.append(numberAsSpoken(num / checkNum));
                    strBuild.append(' ');
                    strBuild.append(numStrings[i]);

                    num %= checkNum;
                }
            }
        }

        if (num > 0) {
            strBuild.append(' ');
            strBuild.append(numberAsSpoken(num));
        }
        return strBuild.toString();
    }

    private static Map<Integer, String> buildSubTwentyMap() {
        Map<Integer, String> subTwentyMap = new HashMap<>();
        subTwentyMap.put(1, "one");
        subTwentyMap.put(2, "two");
        subTwentyMap.put(3, "three");
        subTwentyMap.put(4, "four");
        subTwentyMap.put(5, "five");
        subTwentyMap.put(6, "six");
        subTwentyMap.put(7, "seven");
        subTwentyMap.put(8, "eight");
        subTwentyMap.put(9, "nine");
        subTwentyMap.put(10, "ten");
        subTwentyMap.put(11, "eleven");
        subTwentyMap.put(12, "twelve");
        subTwentyMap.put(13, "thirteen");
        subTwentyMap.put(14, "fourteen");
        subTwentyMap.put(15, "fifteen");
        subTwentyMap.put(16, "sixteen");
        subTwentyMap.put(17, "seventeen");
        subTwentyMap.put(18, "eighteen");
        subTwentyMap.put(19, "nineteen");
        return subTwentyMap;
    }

    private static Map<Integer, String> buildSubOneHundredMap() {
        Map<Integer, String> subOneHundredMap = new HashMap<>();
        subOneHundredMap.put(2, "twenty");
        subOneHundredMap.put(3, "thirty");
        subOneHundredMap.put(4, "forty");
        subOneHundredMap.put(5, "fifty");
        subOneHundredMap.put(6, "sixty");
        subOneHundredMap.put(7, "seventy");
        subOneHundredMap.put(8, "eighty");
        subOneHundredMap.put(9, "ninety");
        return subOneHundredMap;
    }
}
