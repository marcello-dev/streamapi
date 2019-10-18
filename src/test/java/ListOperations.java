package test.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {

    @Test
    public void initializeIntegerListTo0(){

        List<Integer> actual = Arrays.stream(new int[3]).boxed().collect(Collectors.toList());
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(0);
        expected.add(0);

        Assert.assertEquals(3,actual.size());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void initializeIntegerListToVal(){

        List<Integer> actual = new ArrayList<>(Arrays.asList(1,1,1));

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);

        Assert.assertEquals(3,actual.size());
        Assert.assertEquals(expected,actual);
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

        Assert.assertEquals(3,actual.size());
        Assert.assertEquals(expected,actual);
    }
}
