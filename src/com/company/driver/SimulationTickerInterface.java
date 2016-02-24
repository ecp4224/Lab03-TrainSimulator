package com.company.driver;

/**
 * Created by corpa on 2/19/2016.
 */
public interface SimulationTickerInterface {

    /**
     * Adds tickable to a list of tickables
     * @param tickable
     */
    public  void addTickable(Tickable tickable);

    /**
     * Ticks in the day
     */
    public void tick();

    /**
     * Begins the ticking for the day
     * @param wait
     * @throws InterruptedException
     */
    public void begin(long wait) throws InterruptedException;
}
