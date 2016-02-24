package com.company;

public interface TrainRoute {

    /**
     *
     * @return reference to the next station in the route
     */
    Station nextStation();

    /**
     * dequeues a station for them station queue
     * @return the dequeued station
     */
    Station gotoNextStation();

    /**
     * @return true if at the end of route
     */
    boolean isEndOfRoute();

    /**
     * switches route to be an outbound or inbound
     */
    void switchRoute();

    /**
     *
     * @return a random station in the stationList
     */
    Station getRandomStation();
}
