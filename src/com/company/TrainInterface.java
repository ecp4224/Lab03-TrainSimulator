package com.company;

import com.company.driver.Tickable;

import java.util.ArrayList;

public interface TrainInterface extends Tickable {

    /**
     *
     * @return arraylist of passengers on the train
     */
    public ArrayList<Passenger> getPassengers();

    /**
     *
     * @return capacity of the train
     */
    public int getCapacity();

    /**
     * sets the capacity of the train
     * @param capacity
     */
    public void setCapacity(int capacity);

    /**
     * removes passengers from the train on the train
     */
    public void removePassengers();

    /**
     * picks up passengers at the station from the queue
     */
    public void pickupPassengers();

    /**
     *
     * @return true if capacity of train is reached
     */
    public boolean isFull();
}
