package edu.coloradomesa.cs.kattisproblems;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BusesTest {

    @Test
    public void printBusNums() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(1);
        input.add(8);
        input.add(2);
        input.add(3);
        input.add(9);
        input.add(6);
        input.add(4);
        String ans = "1-4 6 8-10";
        Buses bus = new Buses();
        bus.busNums = input;
        assertEquals(ans, bus.printBusNums());
    }
}