package hrank.arrays;

import java.util.Map;
import java.util.TreeMap;

public class OverlappingQueries {

    /*
    Challenge:
    Given n, the length of a 1-indexed array of zeros,
    and queries, an array of integer arrays representing sections and values,
    determine the highest value in the 1-indexed array.

    Each int[] in queries has 3 positions.
    Index 0 holds an inclusive starting index of a section of the 1-indexed array.
    Index 1 holds an inclusive ending index of a section of the 1-indexed array.
    Index 2 is the value to add to each position of the defined section.
     */

    /*
    The most straight forward solution is to create the 1-indexed array
    and add the values given by each query to the appropriate section of
    the array. When complete, simply check the array for its highest value
    and return.

    The issue with that solution comes into play when the sections defined by
    the queries are too large. A very long array with queries that apply to the
    whole array would mean a full iteration of the array for every query. So the
    time efficiency is O(n^2).

    A way around this problem is to abandon the actual array and pay attention
    to the start and end points defined by each query. As each section is encountered
    in order, the value will increase. And as each section is passed, the value decreases.
    In order to track the change at each significant position, the position can be stored as
    a key in a HashMap. The value of every starting position stores an increase and, because
    the ending is inclusive, the position after the ending should store a decrease.

    The keys in a HashMap are unordered. But a TreeMap stores keys in sorted order while
    still preventing duplicate keys! So using a TreeMap allows an iteration in order of only
    the significant points where values change. This max value can be found through that iteration
    and returned.

    The end result of this method is a time complexity of O(n).
     */
    static long arrayManipulation(int n, int[][] queries) {
        long max = Long.MIN_VALUE;
        long counter = 0;
        TreeMap<Integer, Long> hMap = new TreeMap<>();

        // adding each start and end key with corresponding increase and decrease of value
        // to TreeMap.
        for (int[] query : queries) {
            hMap.put(query[0], hMap.getOrDefault(query[0], (long) 0) + query[2]);
            hMap.put(query[1] + 1, hMap.getOrDefault(query[1] + 1, (long) 0) - query[2]);
        }

        // find highest value
        for (Map.Entry<Integer, Long> entry : hMap.entrySet()) {
            counter += entry.getValue();
            if (counter > max) max = counter;
        }

        return max;
    }
}
