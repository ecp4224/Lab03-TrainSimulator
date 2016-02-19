package com.company.driver;

/**
 * Created by corpa on 2/19/2016.
 */
public interface SimulationTickerInterface {

    public  void addTickable(Tickable tickable);

    public void tick();

    public void begin(long wait) throws InterruptedException;
}
