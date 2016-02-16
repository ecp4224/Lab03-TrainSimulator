package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public class Station implements StationInterface{

    private String name;
    private Train currentTrain;
    private boolean isInbound;
    private Queue<Passenger> trainLine;


    public Station(String name, boolean isInbound) {
        this.name = name;
        this.isInbound = isInbound;
        this.trainLine = new Queue<Passenger>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (isInbound != station.isInbound) return false;
        if (!name.equals(station.name)) return false;
        if (currentTrain != null ? !currentTrain.equals(station.currentTrain) : station.currentTrain != null)
            return false;
        return trainLine.equals(station.trainLine);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (currentTrain != null ? currentTrain.hashCode() : 0);
        result = 31 * result + (isInbound ? 1 : 0);
        result = 31 * result + trainLine.hashCode();
        return result;
    }

    public void addPassenger(Passenger p) {
        trainLine.enqueue(p);
    }
}
