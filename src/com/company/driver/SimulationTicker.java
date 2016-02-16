package com.company.driver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimulationTicker {
    private List<Tickable> tickables = new LinkedList<Tickable>();

    public  void addTickable(Tickable tickable) {
        tickables.add(tickable);
    }

    public void tick() {
        for (Tickable t : tickables) {
            t.tick();
        }
    }

    public void begin(long wait) throws InterruptedException {
        while (true) {
            tick();

            Thread.sleep(wait);
        }
    }
}
