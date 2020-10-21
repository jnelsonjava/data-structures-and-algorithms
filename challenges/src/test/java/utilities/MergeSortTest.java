package utilities;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void testEasySort() {
        int[] arr = {8,4,23,42,16,15};
        int[] expected = {4,8,15,16,23,42};

        MergeSort.mergeSort(arr);
        assertArrayEquals("arr should be sorted in place", expected, arr);

        int[] arr2 = {9,6,10,1000,-1,-5};
        int[] expected2 = {-5,-1,6,9,10,1000};

        MergeSort.mergeSort(arr2);
        assertArrayEquals("arr should be sorted in place", expected2, arr2);
    }

    @Test
    public void testEmptyInput() {
        int[] arr = {};
        int[] expected = {};

        MergeSort.mergeSort(arr);
        assertArrayEquals("empty array should be unchanged", expected, arr);
    }

    @Test
    public void testSingleValue() {
        int[] arr = {2};
        int[] expected = {2};

        MergeSort.mergeSort(arr);
        assertArrayEquals("array with a single position should be unchanged", expected, arr);
    }

    @Test
    public void testFullReverseSort() {
        int[] arr = {20,18,12,8,5,-2};
        int[] expected = {-2,5,8,12,18,20};

        MergeSort.mergeSort(arr);
        assertArrayEquals("array should be reversed", expected, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {-2,5,8,12,18,20};
        int[] expected = {-2,5,8,12,18,20};

        MergeSort.mergeSort(arr);
        assertArrayEquals("array should be unchanged", expected, arr);
    }

    @Test
    public void testDuplicateValues() {
        int[] arr = {5,12,7,5,5,7};
        int[] expected = {5,5,5,7,7,12};

        MergeSort.mergeSort(arr);
        assertArrayEquals("array should be sorted", expected, arr);
    }
}
