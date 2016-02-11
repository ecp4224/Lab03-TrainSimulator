package com.company;

import com.company.driver.SimulationTicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TrainRouteBuilder {
    private static final Random RANDOM = new Random();

    private List<String> stations = new ArrayList<String>();
    private SimulationTicker ticker;

    private TrainRouteBuilder(SimulationTicker ticker) { this.ticker = ticker; }

    public static TrainRouteBuilder createBuilder(SimulationTicker ticker) {
        if (ticker == null)
            throw new IllegalArgumentException("ticker cannot be null!");

        return new TrainRouteBuilder(ticker);
    }

    public TrainRouteBuilder addStation(String name) {
        stations.add(name);
        return this;
    }

    public List<Station> createStations() {
        List<Station> _stations = new ArrayList<>();

        for (int i = 0; i < stations.size(); i++) {
            TrainRoute inBoundRoute = new SimpleTrainRoute(this, i, false);
            TrainRoute outBoundRoute = new SimpleTrainRoute(this, i, true);

            Station inboundStation = inBoundRoute.gotoNextStation(); //Pop first station
            Station outboundStation = outBoundRoute.gotoNextStation(); //Pop first station

            Train inBoundTrain = new Train(inboundStation, RANDOM.nextInt(30) + 10, inBoundRoute);
            Train outBoundTrain = new Train(outboundStation, RANDOM.nextInt(30) + 10, outBoundRoute);

            inboundStation.setCurrentTrain(inBoundTrain);
            outboundStation.setCurrentTrain(outBoundTrain);

            ticker.addTickable(inBoundTrain);
            ticker.addTickable(outBoundTrain);

            _stations.add(inboundStation);
            _stations.add(outboundStation);
        }

        return Collections.unmodifiableList(_stations);
    }

    public Station[] buildInbound() {
        Station[] toReturn = new Station[stations.size()];
        for (int i = 0; i < stations.size(); i++) {
            toReturn[i] = new Station(stations.get(i), true);
        }

        return toReturn;
    }

    public Station[] buildOutbound() {
        Station[] toReturn = new Station[stations.size()];
        for (int i = stations.size() - 1; i >= 0; i--) {
            toReturn[toReturn.length - 1 - i] = new Station(stations.get(i), false);
        }

        return toReturn;
    }
}
