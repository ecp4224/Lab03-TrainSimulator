package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public class Passenger {

    private int passengerID;
    private Station currentStation;
    private Station nextStation;
    private Train currentTrain;

    public Passenger() {

    }

    public boolean isOnTrain(){
        if(currentTrain != null)
            return true;
        return false;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }
}
