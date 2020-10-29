package utilities;

import java.util.Arrays;
import java.util.HashMap;

public class LeftJoin {
    public static String[][] leftJoinHashMaps(HashMap<String, String> leftMap, HashMap<String, String> rightMap) {
        String[][] joinedArray = new String[leftMap.size()][3];
        int i = 0;
        for (String key : leftMap.keySet()) {
            joinedArray[i][0] = key;
            joinedArray[i][1] = leftMap.get(key);
            i++;
        }
        for (String[] strArr : joinedArray) {
            strArr[2] = rightMap.getOrDefault(strArr[0], null);
        }
        return joinedArray;
    }
}
