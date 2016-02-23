package com.company;

/**
 * Created by corpa on 2/22/2016.
 */
public class Day {

    private int timeOfDay;

    public Day() {
        timeOfDay = 0;
    }

    public void progressDay(){
        if(timeOfDay == 23000)
            timeOfDay = 0;
        else
            timeOfDay += 1000;
    }

    public int getTimeOfDay() {
        return timeOfDay;
    }
}
