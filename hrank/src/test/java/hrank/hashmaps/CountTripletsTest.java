package hrank.hashmaps;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class CountTripletsTest {
    @Test
    public void testSample1() {
        long r = 2;
        List<Long> arr = new ArrayList<Long>(Arrays.asList(1L, 2L, 2L, 4L));
        long expected = 2;
        assertEquals("should find the triplets based on given ratio", expected, CountTriplets.countTriplets(arr, r));
    }

    @Test
    public void testSample2() {
        long r = 3;
        List<Long> arr = new ArrayList<Long>(Arrays.asList(1L,3L,9L,9L,27L,81L));
        long expected = 6;
        assertEquals("should find the triplets based on given ratio", expected, CountTriplets.countTriplets(arr, r));
    }

    @Test
    public void testSample3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\countTripleSample3.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long r = Long.parseLong(nr[1]); // 3

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long expected = 1667018988625L;
        assertEquals("should find the triplets based on given ratio", expected, CountTriplets.countTriplets(arr, r));
    }

    @Test
    public void testSample4() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\countTripleSample4.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long r = Long.parseLong(nr[1]); // 10

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long expected = 2325652489L;
        assertEquals("should find the triplets based on given ratio", expected, CountTriplets.countTriplets(arr, r));
    }

    @Test
    public void testSample5() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\countTripleSample5.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long expected = 1339347780085L;
        assertEquals("should find the triplets based on given ratio", expected, CountTriplets.countTriplets(arr, r));
    }
}
