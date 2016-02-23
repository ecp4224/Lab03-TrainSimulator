package com.company;

/**
 * Created by corpa on 2/22/2016.
 */
public class Day implements DayInterface{

    private int timeOfDay;
    private int dayNumber;

    public Day() {
        timeOfDay = 0;
        dayNumber = 0;
    }

    public void progressDay(){
        if(timeOfDay == 2300) {
            timeOfDay = 0;
            dayNumber++;
        } else{
            timeOfDay += 100;//add an hour
        }
    }

    public int getTimeOfDay() {
        return timeOfDay;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public boolean isRushHour(){
        return this.timeOfDay == 700 || this.timeOfDay == 600 || this.timeOfDay == 1700 || this.timeOfDay == 1800;
    }
}
