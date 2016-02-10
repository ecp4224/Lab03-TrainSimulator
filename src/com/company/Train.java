package com.company;

import java.util.ArrayList;

/**
 * Created by corpa on 2/10/2016.
 */
public class Train implements TrainInterface{

    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    //private TrainRoute route = new Train();

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
        int amountDroppedOff = 0;
        for(Passenger p: getPassengers()){
            if(p.getDestinationStation().equals(currentStation.getName())) {
                passengers.remove(p);
                numberOfPassengers--;
                amountDroppedOff++;
            }
        }
        System.out.println("Dropped off " + amountDroppedOff + " passengers at " + currentStation.getName());
    }

    public void pickupPassengers() {
        int amountPickedUp = 0;
        while(!isFull()){
            if(currentStation.getTrainLine().getFront().getDestinationStation().getName().equals(currentStation.getName())) {
                currentStation.getTrainLine().dequeue();
                numberOfPassengers++;
                amountPickedUp++;
            }
        }
        System.out.println("Picked up " + amountPickedUp + " passengers at " + currentStation.getName());
    }

    public boolean isFull() {
        return (this.numberOfPassengers == this.capacity);
    }

}
