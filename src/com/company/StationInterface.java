package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public interface StationInterface {

    /**
     * @return name of station
     */
    public String getName();

    /**
     * sets the name of the station
     * @param name
     */
    public void setName(String name);

    /**
     * @return current train at the station
     */
    public Train getCurrentTrain();

    /**
     * set the currentTrain to be at the station
     * @param currentTrain
     */
    public void setCurrentTrain(Train currentTrain);

    /**
     * @return true if the station is an inbound station
     */
    public boolean isInbound();

    /**
     * sets a station to be an inbound station
     * @param isInbound
     */
    public void setIsInbound(boolean isInbound);

    /**
     * @return the line of passengers at the station
     */
    public Queue<Passenger> getTrainLine();

}
