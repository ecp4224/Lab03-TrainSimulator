package com.company;

public interface PassengerInterface {

    /**
     * @return true if passenger is currently on a train
     */
    public boolean isOnTrain();

    /**
     * @return the passengerID
     */
    public int getPassengerID();

    /**
     * @return the station the passenger is currently at
     */
    public Station getCurrentStation();

    /**
     * @return the station the passenger is going to
     */
    public Station getDestinationStation();

    /**
     * @return the train the passenger is currently on
     */
    public Train getCurrentTrain();

}
