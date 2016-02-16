package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Train implements TrainInterface {

    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    //private TrainRoute route = new Train();

    private Station currentStation;
    private Station nextStation;

    private int numberOfPassengers;//Number of passengers in train Currently
    private int capacity;//Number of passengers allowed in train

    private TrainRoute route;

    public Train(Station currentStation, int capacity, TrainRoute route) {
        this.currentStation = currentStation;
        this.route = route;
        this.capacity = capacity;
        numberOfPassengers = 0;
        nextStation = route.nextStation();
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

        //Use iterator to prevent ConcurrentModificationException
        Iterator<Passenger> iterator = getPassengers().iterator();
        while (iterator.hasNext()) {
            Passenger p = iterator.next();
            if (p.getDestinationStation().equals(currentStation)) {
                iterator.remove();
                numberOfPassengers--;
                amountDroppedOff++;
            }
        }

        if (amountDroppedOff > 0)
            System.out.println("Dropped off " + amountDroppedOff + " passengers at " + currentStation.getName());
    }

    public void pickupPassengers() {
        int amountPickedUp = 0;
        while(!isFull()) {
            if (currentStation.getTrainLine().isEmpty())
                break;

            passengers.add(currentStation.getTrainLine().dequeue());
            numberOfPassengers++;
            amountPickedUp++;
        }
        if (amountPickedUp > 0)
            System.out.println("Picked up " + amountPickedUp + " passengers at " + currentStation.getName());
    }

    public boolean isFull() {
        return (this.numberOfPassengers == this.capacity);
    }

    @Override
    public void tick() {
        removePassengers();

        if (route.isEndOfRoute()) {
            route.switchRoute();
        }

        System.out.print("Train moved from " + currentStation.getName());
        currentStation = route.gotoNextStation();
        System.out.print(" to " + currentStation.getName() + ".\n");
        nextStation = getTrainRoute().nextStation();
        pickupPassengers();
    }

    public TrainRoute getTrainRoute() {
        return route;
    }
}
