package org.playground.streamapi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOperations {

    @Test
    public void initializeIntegerListTo0(){

        List<Integer> actual = Arrays.stream(new int[3]).boxed().collect(Collectors.toList());
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(0);
        expected.add(0);

        assertEquals(3,actual.size());
        assertEquals(expected,actual);
    }

    @Test
    public void initializeIntegerListToVal(){

        List<Integer> actual = new ArrayList<>(Arrays.asList(1,1,1));

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);

        assertEquals(3,actual.size());
        assertEquals(expected,actual);
    }
    @Test
    public void initializeIntegerListToVal2(){
        int[] array = new int[3];
        Arrays.fill(array,1);
        List<Integer> actual = Arrays.stream(array).boxed().collect(Collectors.toList());

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);

        assertEquals(3,actual.size());
        assertEquals(expected,actual);
    }
}
