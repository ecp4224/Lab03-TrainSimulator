package com.company.driver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimulationTicker {
    private static List<Tickable> tickables = new LinkedList<>();

    public static void addTickable(Tickable tickable) {
        tickables.add(tickable);
    }

    public static void tick() {
        for (Tickable t : tickables) {
            t.tick();
        }
    }

    public static void main(String[] args) {
        //TODO Make main
    }
}
