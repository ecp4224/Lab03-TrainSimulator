package com.company;

import java.util.ArrayList;

/**
 * Created by corpa on 2/10/2016.
 */
public interface TrainInterface {

    public ArrayList<Passenger> getPassengers();

    public int getCapacity();

    public void setCapacity(int capacity);

    public void removePassengers();

    public void pickupPassengers();

    public boolean isFull();
}
