package com.company;

import java.util.ArrayList;

/**
 * Created by corpa on 2/10/2016.
 */
public class Train {

    private ArrayList<Passenger> passengers = new ArrayList<>();

    private int capacity;

    public Train() {

    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
