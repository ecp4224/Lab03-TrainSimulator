package com.company;

/**
 * Created by corpa on 2/23/2016.
 */
public interface DayInterface {

    /**
     * Adds an hour to the day
     */
    public void progressDay();

    /**
     * @return the time of day
     */
    public int getTimeOfDay();

    /**
     * @return the day you are on
     */
    public int getDayNumber();

    /**
     *
     * @return true if it is 5-6pm or 6-7am
     */
    public boolean isRushHour();

}
