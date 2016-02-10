package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public class Passenger implements PassengerInterface{

    private int passengerID;
    private Station currentStation;
    private Station destinationStation;
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

    public Station getDestinationStation() {
        return destinationStation;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }
}
