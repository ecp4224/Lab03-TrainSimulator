package com.company;

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
        return name + " (" + (isInbound ? "INBOUND" : "OUTBOUND") + ")";
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

        return isInbound == station.isInbound && name.equals(station.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (isInbound ? 1 : 0);
        return result;
    }

    public void addPassenger(Passenger p) {
        trainLine.enqueue(p);
    }
}
