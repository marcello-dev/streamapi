package org.playground.streamapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamOperations {

    private List<Driver> drivers;

    @BeforeEach
    public void setUp() {
        drivers = new ArrayList<>();
        Driver d1 = new Driver("a","b",null);
        d1.setInfo(new ArrayList<>(Arrays.asList("patente","libretto")));
        Driver d2 = new Driver("c","d",new Vehicle(2));
        d2.setInfo(new ArrayList<>(Arrays.asList("documento1","patente")));

        drivers.add(d1); drivers.add(d2);
    }

    @Test
    public void matchAny_staticMethod(){
        // Reference to a Static Method
        boolean anyRealDrivers = drivers.stream().anyMatch(Driver::isRealDriver);

        assertTrue(anyRealDrivers);
    }

    @Test
    public void matchAny_if_predicate(){
        boolean anyCalledA = drivers.stream().anyMatch(d -> d.getName().equals("a"));

        assertTrue(anyCalledA);
    }

    @Test
    public void filterArray(){
        int[] array = {1,2,3,4,5,6,7,8};
        int[] expected = {2,4,6,8};

        int[] actual = Arrays.stream(array).filter((x)-> x%2==0).toArray();

        assertArrayEquals(expected,actual);
    }

    @Test
    public void filterObjects(){
        // Reference to an Instance Method of an Object of a Particular Type
        List<String> strings = new ArrayList<>(Arrays.asList("a","b",""));

        long emptyStrings = strings.stream().filter(String::isEmpty).count();

        assertEquals(1,emptyStrings);
    }

    @Test
    public void flatMap() {
        List<String> expected = drivers.get(0).getInfo();
        expected.addAll(drivers.get(1).getInfo());

        Stream<String> info = drivers.stream().flatMap(d -> d.getInfo().stream());
        List<String> infoStrings = info.collect(Collectors.toList());

        //Assert.assertEquals(expected,infoStrings);
    }

}
