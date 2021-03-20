package hrank.advanced;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class SelfDrivingBusTest {
    private static int getN(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        return Integer.parseInt(bufferedReader.readLine());
    }

    private static int[][] getEdges(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        int queryCount = Integer.parseInt(bufferedReader.readLine());

        int[][] queries = new int[queryCount - 1][2];

        int i = 0;
        while (bufferedReader.ready()) {
            String[] edge = bufferedReader.readLine().split(" ");
            queries[i][0] = Integer.parseInt(edge[0]);
            queries[i][1] = Integer.parseInt(edge[1]);
            i++;
        }

        return queries;
    }

    @Test
    public void readerNTest() {
        int n = 0;
        try {
            n = getN("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample0.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("test reader should get first number from file", 3, n);
    }

    @Test
    public void readerEdgeTest() {
        int n = 0;
        try {
            n = getN("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample0.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] edges = new int[n - 1][2];
        try {
            edges = getEdges("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample0.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.deepToString(edges));
        assertEquals("queries should be elements in returned array", "[[1, 3], [3, 2]]", Arrays.deepToString(edges));
    }

    @Test
    public void testSample0() {
        int n = 0;
        try {
            n = getN("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample0.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] edges = new int[n - 1][2];
        try {
            edges = getEdges("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample0.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = SelfDrivingBus.solve(edges);
        assertEquals("", 5, result);
    }

    @Test
    public void testSample8() {
        int n = 0;
        try {
            n = getN("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample8.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] edges = new int[n - 1][2];
        try {
            edges = getEdges("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample8.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = SelfDrivingBus.solve(edges);
        assertEquals("", 2001000, result);
    }

    @Test
    public void testSample2() {
        int n = 0;
        try {
            n = getN("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] edges = new int[n - 1][2];
        try {
            edges = getEdges("E:\\codefellows\\classprojects\\401\\data-structures-and-algorithms\\hrank\\src\\test\\resources\\selfDrivingBusSample2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = SelfDrivingBus.solve(edges);
        assertEquals("", 3999, result);
    }
}
