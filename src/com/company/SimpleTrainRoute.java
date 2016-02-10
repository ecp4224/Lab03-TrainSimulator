package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimpleTrainRoute implements TrainRoute {
    private Queue<Station> stations;
    private TrainRouteBuilder builder;

    public SimpleTrainRoute(TrainRouteBuilder builder, Station startingStation, boolean isOutbound) {
        Station[] stations = (isOutbound ? builder.buildOutbound() : builder.buildInbound());

        this.stations = new Queue<>();

        int startingIndex = 0;
        boolean build = false;
        for (; startingIndex < stations.length; startingIndex++) {
            if (stations[startingIndex] == startingStation) {
                build = true;
            }

            if (build) {
                this.stations.enqueue(stations[startingIndex]);
            }
        }
    }

    @Override
    public Station nextStation() {
        return stations.getFront();
    }

    @Override
    public Station gotoNextStation() {
        return stations.dequeue();
    }
}
