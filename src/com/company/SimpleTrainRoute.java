package com.company;

import java.util.*;

public class SimpleTrainRoute implements TrainRoute {

    private List<Station> stationsList = new ArrayList<>();
    private Queue<Station> stations;
    private TrainRouteBuilder builder;
    private boolean isGoingOutbound;

    public SimpleTrainRoute(TrainRouteBuilder builder, int startingStation, boolean isOutbound) {
        isGoingOutbound = isOutbound;
        this.builder = builder;
        build(isOutbound, startingStation);
    }

    private void build(boolean isOutbound, int startingStation) {
        Station[] stations = (isOutbound ? builder.buildOutbound() : builder.buildInbound());

        this.stations = new Queue<Station>();

        int startingIndex = 0;
        boolean build = false;
        for (; startingIndex < stations.length; startingIndex++) {
            if (startingIndex == startingStation) {
                build = true;
            }

            if (build) {
                this.stations.enqueue(stations[startingIndex]);
                this.stationsList.add(stations[startingIndex]);
            }
        }
    }

    @Override
    public Station nextStation() {
        return stations.getFront();
    }

    @Override
    public Station gotoNextStation() {
        stationsList.remove(0);
        return stations.dequeue();
    }

    @Override
    public boolean isEndOfRoute() {
        return stations.isEmpty();
    }

    @Override
    public void switchRoute() {
        isGoingOutbound = !isGoingOutbound;
        build(isGoingOutbound, 0);
    }

    @Override
    public Station getRandomStation() {
        List<Station> all = builder.getAllStations();
        Random random = new Random();

        if(!isEndOfRoute()) {
            return stationsList.get(random.nextInt(stationsList.size()));
        } else {
            return all.get(random.nextInt(all.size()));
        }
    }
}
