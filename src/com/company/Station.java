package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public class Station {

    private String name;
    private Train currentTrain;
    private boolean isInbound;
    private Queue<Passenger> trainLine;


    public Station() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    public boolean isInbound() {
        return isInbound;
    }

    public void setIsInbound(boolean isInbound) {
        this.isInbound = isInbound;
    }

    public Queue<Passenger> getTrainLine() {
        return trainLine;
    }

}
