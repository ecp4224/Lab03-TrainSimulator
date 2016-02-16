package com.company;

public class Passenger implements PassengerInterface{

    private int passengerID;
    private Station currentStation;
    private Station destinationStation;
    private Train currentTrain;

    private static int nextPassengerID = 0;
    public static Passenger createPassenger(Station currentStation) {
        Station destination = currentStation.getCurrentTrain().getTrainRoute().getRandomStation();
        nextPassengerID++;
        return new Passenger(currentStation, destination, nextPassengerID);
    }

    private Passenger(Station currentStation, Station destinationStation, int id){
        this.currentStation = currentStation;
        this.destinationStation = destinationStation;
        currentTrain = null;
        passengerID = id;
    }

    public boolean isOnTrain(){
        return currentTrain != null;
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
