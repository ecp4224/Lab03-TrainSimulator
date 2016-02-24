package com.company.driver;

import com.company.Day;
import com.company.Passenger;
import com.company.Station;

import java.util.List;
import java.util.Random;

public class PassengerCreator implements Tickable, PassengerCreatorInterface {

    private static final Random RANDOM = new Random();
    private static final long MIN_WAIT_TIME = 20000;

    private List<Station> allStations;
    private long lastAdd;

    private Day day;

    public PassengerCreator(List<Station> allStations, Day day) {
        this.allStations = allStations;
        this.day = day;
    }

    @Override
    public void tick() {
        if (System.currentTimeMillis() - lastAdd < MIN_WAIT_TIME)
            return;
        for (Station s : allStations) {
            int passengerCount;
            if (day.isRushHour()) {
                passengerCount = RANDOM.nextInt(120) + 1;
            } else {
                passengerCount = RANDOM.nextInt(40) + 1;
            }
            for (int i = 0; i < passengerCount; i++) {
                Passenger p = Passenger.createPassenger(s);

                s.addPassenger(p);
            }

            //System.out.println("Added " + passengerCount + " passengers to the line at " + s.getName());
            //}
        }

        lastAdd = System.currentTimeMillis();
        System.out.println();
    }
}
