package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public interface PassengerInterface {

    public boolean isOnTrain();

    public int getPassengerID();

    public Station getCurrentStation();

    public Station getDestinationStation();

    public Train getCurrentTrain();

}
