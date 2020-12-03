package hrank.arrays;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class OverlappingQueriesTest {
    @Test
    public void testSampleCase1() {
        int[] a = {1,2,100};
        int[] b = {2,5,100};
        int[] c = {3,4,100};

        int[][] queries = {a,b,c};
        int n = 5;

        assertEquals("should return the highest value", (long) 200, OverlappingQueries.arrayManipulation(n, queries));
    }

    @Test
    public void testSampleCase2() {
        int[] a = {1,5,3};
        int[] b = {4,8,7};
        int[] c = {6,9,1};

        int[][] queries = {a,b,c};
        int n = 10;

        assertEquals("should return the highest value", (long) 10, OverlappingQueries.arrayManipulation(n, queries));
    }

    @Test
    public void testSampleCase3() {
        int[] a = {2,6,8};
        int[] b = {3,5,7};
        int[] c = {1,8,1};
        int[] d = {5,9,15};

        int[][] queries = {a,b,c,d};
        int n = 10;

        assertEquals("should return the highest value", (long) 31, OverlappingQueries.arrayManipulation(n, queries));
    }
}
