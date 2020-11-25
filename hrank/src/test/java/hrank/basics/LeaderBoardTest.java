package hrank.basics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LeaderBoardTest {
    @Test
    public void testSample1() {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 100, 50, 40, 40, 20, 10));
        List<Integer> player = new ArrayList<>(Arrays.asList(5, 25, 50, 120));
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 4, 2, 1));
        List<Integer> output = LeaderBoard.climbingLeaderboard(ranked, player);

        assertEquals("output should be same size as expected", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals("all output values should match expected ranks", expected.get(i), output.get(i));
        }
    }

    @Test
    public void testSample2() {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 90, 90, 80, 75, 60));
        List<Integer> player = new ArrayList<>(Arrays.asList(50, 65, 77, 90, 102));
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 5, 4, 2, 1));
        List<Integer> output = LeaderBoard.climbingLeaderboard(ranked, player);

        assertEquals("output should be same size as expected", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals("all output values should match expected ranks", expected.get(i), output.get(i));
        }
    }

    @Test
    public void testEmptyRankings() {
        List<Integer> ranked = new ArrayList<>();
        List<Integer> player = new ArrayList<>(Arrays.asList(50, 65, 77, 90, 102));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        List<Integer> output = LeaderBoard.climbingLeaderboard(ranked, player);

        assertEquals("output should be same size as expected", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals("all output values should match expected ranks", expected.get(i), output.get(i));
        }
    }

    @Test
    public void testNoPlayer() {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 90, 90, 80, 75, 60));
        List<Integer> player = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        List<Integer> output = LeaderBoard.climbingLeaderboard(ranked, player);

        assertEquals("output should be same size as expected", expected.size(), output.size());
    }
}
