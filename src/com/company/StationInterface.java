package com.company;

/**
 * Created by corpa on 2/10/2016.
 */
public interface StationInterface {

    public String getName();

    public void setName(String name);

    public Train getCurrentTrain();

    public void setCurrentTrain(Train currentTrain);

    public boolean isInbound();

    public void setIsInbound(boolean isInbound);

    public Queue<Passenger> getTrainLine();

}
