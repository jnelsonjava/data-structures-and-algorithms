package utilities;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LeftJoinTest {
    @Test
    public void testBasicJoin() {
        HashMap<String, String> leftMap = new HashMap<>();
        leftMap.put("fond", "enamored");
        leftMap.put("wrath", "anger");
        leftMap.put("diligent", "employed");
        leftMap.put("outfit", "garb");
        leftMap.put("guide", "usher");

        HashMap<String, String> rightMap = new HashMap<>();
        rightMap.put("fond", "averse");
        rightMap.put("wrath", "delight");
        rightMap.put("diligent", "idle");
        rightMap.put("guide", "follow");
        rightMap.put("flow", "jam");

        String[][] expected = new String[5][3];
        String[] helper = {"fond","wrath","diligent","outfit","guide","enamored","anger","employed","garb","usher","averse","delight","idle", null,"follow"};
//        int i = 0;
        for (int i = 0; i < helper.length; i++) {
            expected[i % 5][i / 5] = helper[i];
            System.out.println(helper[i]);
        }
        System.out.println(Arrays.deepToString(expected));

        String[][] result = LeftJoin.leftJoinHashMaps(leftMap, rightMap);

        System.out.println(Arrays.deepToString(result));

        assertEquals("Size of outer array should be the same", expected.length, result.length);

        for (int j = 0; j < expected.length; j++) {
            assertEquals("inner arrays should all be equal length", expected[j].length, result[j].length);
        }

        for (String[] expectedInnerArr : expected) {
            for (String[] resultInnerArr : result) {
                if (expectedInnerArr[0].equals(resultInnerArr[0])) {
                    assertEquals("values following same key should match expected", expectedInnerArr[1], resultInnerArr[1]);
                    assertEquals("values following same key should match expected", expectedInnerArr[2], resultInnerArr[2]);
                    break;
                }
            }
        }
    }
}
