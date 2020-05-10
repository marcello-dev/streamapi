package org.playground.streamapi;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperations {


    @Test
    public void initializeArrayTo0() {
        // automatically to default value 0!
        int[] array = new int[2];
        int[] expected = new int[]{0, 0};

        assertArrayEquals(expected, array);
    }

    @Test
    public void initializeArrayToVal() {
        int[] array = new int[2];
        int[] expected = new int[]{5, 5};

        Arrays.fill(array, 5);
        assertArrayEquals(expected, array);
    }

    @Test
    public void addExtraElementToArray() {
        int[] array = {1, 2, 3, 4};
        int[] actual = Arrays.copyOf(array, array.length + 1);
        actual[actual.length - 1] = 5;

        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayEquals() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4};

        assertTrue(Arrays.equals(array1, array2));
    }

    @Test
    public void arrayEmpty() {
        int[] array = {};
        boolean isEmpty = array == null || array.length == 0;
        assertTrue(isEmpty);
    }

    @Test
    public void removeDuplicates() {
        List<Integer> integers = new ArrayList<>() {{
            add(1);
            add(2);
            add(2);
        }};
        List<Integer> expected = new ArrayList<>() {{
            add(1);
            add(2);
        }};

        Set<Integer> set = new HashSet<>(integers);
        List<Integer> actual = new ArrayList<>(set);

        assertEquals(expected, actual);
    }

    @Test
    public void convertIntArrayToIntegerList() {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> integers = Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    @Test
    public void convertIntegerListToIntArray() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        int[] intArray = integerList.stream().mapToInt(x -> x).toArray();
    }

    @Test
    public void convertIntegerArrayToList() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> integers = Arrays.asList(array);
    }

    @Test
    public void mapToObject() {
        int[] array = {1};

        String[] strings = Arrays.stream(array).mapToObj(x -> String.format("Val%d", x)).toArray(String[]::new);

        assertEquals("Val1", strings[0]);
    }

    @Test
    public void mapStringToInt() {
        List<String> strings = new ArrayList<>() {{
            add("1");
            add("2");
        }};

        int[] expected = strings.stream().mapToInt(Integer::parseInt).toArray();

        assertEquals(1, expected[0]);
    }

    @Test
    public void binarySearch() {
        String[] strings = new String[]{"2", "22", "234"};
        Arrays.sort(strings);
        int expected = Arrays.binarySearch(strings, "2");

        assertEquals(0, expected);
    }


}
