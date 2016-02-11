package com.company;

import com.company.driver.Tickable;

import java.util.ArrayList;

public interface TrainInterface extends Tickable {

    public ArrayList<Passenger> getPassengers();

    public int getCapacity();

    public void setCapacity(int capacity);

    public void removePassengers();

    public void pickupPassengers();

    public boolean isFull();
}
