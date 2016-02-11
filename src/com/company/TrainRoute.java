package com.company;

public interface TrainRoute {
    Station nextStation();

    Station gotoNextStation();

    boolean isEndOfRoute();

    void switchRoute();
}
