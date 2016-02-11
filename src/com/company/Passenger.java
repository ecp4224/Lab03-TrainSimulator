package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public class Passenger implements PassengerInterface{

    private int passengerID = 0;
    private Station currentStation;
    private Station destinationStation;
    private Train currentTrain;

    public Passenger(){
        passengerID++;
        currentStation = null;
        destinationStation = null;
        currentTrain = null;
    }

    public Passenger(Station currentStation, Station destinationStation){
        this.currentStation = currentStation;
        this.destinationStation = destinationStation;
        currentTrain = null;
        passengerID++;
    }

    public boolean isOnTrain(){
        if(currentTrain != null)
            return true;
        return false;

    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public void setCurrentStation(Station currentStation) {
        this.currentStation = currentStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
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
