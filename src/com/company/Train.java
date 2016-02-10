package com.company;

import java.util.ArrayList;

/**
 * Created by corpa on 2/10/2016.
 */
public class Train implements TrainInterface{

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private TrainRoute route = new TrainRoute();

    private Station currentStation;
    private Station nextStation;

    private int numberOfPassengers;//Number of passengers in train Currently
    private int capacity;//Number of passengers allowed in train

    public Train(Station currentStation, int capacity) {
        this.currentStation = currentStation;
        this.capacity = capacity;
        numberOfPassengers = 0;
        nextStation = route.getNextStation(currentStation);//TODO EDDIE
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void removePassengers() {
        for(Passenger p: getPassengers()){
            if(p.getDestinationStation().equals(currentStation.getName()))
                passengers.remove(p);
        }
    }

    public void pickupPassengers() {
        while(!isFull()){
            /*if(currentStation.getTrainLine().getFront().getDestinationStation().getName().equals(currentStation.getName()))
                currentStation.getTrainLine().enqueue();*/ //TODO FINISH THIS
        }
    }

    public boolean isFull() {
        return (this.numberOfPassengers == this.capacity);
    }

}
