package hrank.basics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RoundingGradesTest {
    @Test
    public void testRoundUp() {
        List<Integer> input = new ArrayList<>(Arrays.asList(38, 43, 63, 78, 99));
        List<Integer> expected = new ArrayList<>(Arrays.asList(40, 45, 65, 80, 100));
        List<Integer> output = RoundingGrades.gradingStudents(input);

        assertEquals("size should match input", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(
                    "each grade should be rounded up to nearest 5",
                    expected.get(i),
                    output.get(i));
        }
    }

    @Test
    public void testRemainingSame() {
        List<Integer> input = new ArrayList<>(Arrays.asList(40, 42, 61, 77, 96));
        List<Integer> expected = new ArrayList<>(Arrays.asList(40, 42, 61, 77, 96));
        List<Integer> output = RoundingGrades.gradingStudents(input);

        assertEquals("size should match input", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(
                    "each grade should remain the same",
                    expected.get(i),
                    output.get(i));
        }
    }

    @Test
    public void testFailing() {
        List<Integer> input = new ArrayList<>(Arrays.asList(37, 34, 24, 17, 4, 0));
        List<Integer> expected = new ArrayList<>(Arrays.asList(37, 34, 24, 17, 4, 0));
        List<Integer> output = RoundingGrades.gradingStudents(input);

        assertEquals("size should match input", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(
                    "each failing grade should remain the same",
                    expected.get(i),
                    output.get(i));
        }
    }

    @Test
    public void testEmptyList() {
        List<Integer> input = new ArrayList<>();
        List<Integer> output = RoundingGrades.gradingStudents(input);

        assertEquals("output should maintain size 0", 0, output.size());
    }

    @Test
    public void testMixedResults() {
        List<Integer> input = new ArrayList<>(Arrays.asList(38, 42, 18, 79, 99, 100));
        List<Integer> expected = new ArrayList<>(Arrays.asList(40, 42, 18, 80, 100, 100));
        List<Integer> output = RoundingGrades.gradingStudents(input);

        assertEquals("size should match input", expected.size(), output.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(
                    "each grade should be rounded up to nearest 5",
                    expected.get(i),
                    output.get(i));
        }
    }
}
