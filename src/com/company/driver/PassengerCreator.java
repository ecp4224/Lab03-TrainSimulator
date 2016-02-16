package com.company.driver;

import com.company.Passenger;
import com.company.Station;

import java.util.List;
import java.util.Random;

public class PassengerCreator implements Tickable {
    private static final Random RANDOM = new Random();
    private static final long MIN_WAIT_TIME = 20000;

    private List<Station> allStations;
    private long lastAdd;
    public PassengerCreator(List<Station> allStations) {
        this.allStations = allStations;
    }

    @Override
    public void tick() {
        if (System.currentTimeMillis() - lastAdd < MIN_WAIT_TIME)
            return;

        if (RANDOM.nextDouble() < 0.1) { //40% chance of adding passengers
            for (Station s : allStations) {
                if (RANDOM.nextBoolean()) {
                    int passengerCount = RANDOM.nextInt(10);
                    for (int i = 0; i < passengerCount; i++) {
                        Passenger p = Passenger.createPassenger(s);

                        s.addPassenger(p);
                    }

                    System.out.println("Added " + passengerCount + " passengers to the line at " + s.getName());
                }
            }

            lastAdd = System.currentTimeMillis();
            System.out.println();
        }
    }
}
