package com.company;

import com.company.driver.SimulationTicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TrainRouteBuilder {
    private static final Random RANDOM = new Random();

    //Create 2 separate array lists for both inbound side and outbound side
    //When creating the route, loop through as if there is only one arraylist (like previous commits)
    //This allows for the possibility of having a station on the inbound side only or outbound side only
    private List<String> inBoundStations = new ArrayList<String>();
    private List<String> outBoundStations = new ArrayList<String>();
    private List<Station> cache;

    private SimulationTicker ticker;

    private TrainRouteBuilder(SimulationTicker ticker) { this.ticker = ticker; }

    public static TrainRouteBuilder createBuilder(SimulationTicker ticker) {
        if (ticker == null)
            throw new IllegalArgumentException("ticker cannot be null!");

        return new TrainRouteBuilder(ticker);
    }

    public TrainRouteBuilder addStation(String name) {
        inBoundStations.add(name);
        outBoundStations.add(name);
        return this;
    }

    public TrainRouteBuilder addInboundStation(String name) {
        inBoundStations.add(name);
        return this;
    }

    public TrainRouteBuilder addOutboundStation(String name) {
        outBoundStations.add(name);
        return this;
    }

    public List<Station> getAllStations() {
        if (cache == null)
            throw new IllegalAccessError("This builder hasn't been built yet!");

        return cache;
    }

    public List<Station> buildStations() {
        cache = new ArrayList<Station>();

        for (int i = 0; i < inBoundStations.size(); i++) {
            TrainRoute inBoundRoute = new SimpleTrainRoute(this, i, false);

            Station inboundStation = inBoundRoute.gotoNextStation(); //Pop first station
            Train inBoundTrain = new Train(inboundStation, RANDOM.nextInt(30) + 10, inBoundRoute);

            inboundStation.setCurrentTrain(inBoundTrain);

            ticker.addTickable(inBoundTrain);
            cache.add(inboundStation);
        }

        for (int i = 0; i < outBoundStations.size(); i++) {
            TrainRoute outBoundRoute = new SimpleTrainRoute(this, i, true);

            Station outboundStation = outBoundRoute.gotoNextStation(); //Pop first station
            Train outBoundTrain = new Train(outboundStation, RANDOM.nextInt(30) + 10, outBoundRoute);

            outboundStation.setCurrentTrain(outBoundTrain);

            ticker.addTickable(outBoundTrain);
            cache.add(outboundStation);
        }

        return Collections.unmodifiableList(cache);
    }

    public Station[] buildInbound() {
        Station[] toReturn = new Station[inBoundStations.size()];
        for (int i = 0; i < inBoundStations.size(); i++) {
            Station temp = new Station(inBoundStations.get(i), true);
            if (cache.contains(temp)) {
                temp = cache.get(cache.indexOf(temp));
            }
            toReturn[i] = temp;
        }

        return toReturn;
    }

    public Station[] buildOutbound() {
        Station[] toReturn = new Station[outBoundStations.size()];
        for (int i = outBoundStations.size() - 1; i >= 0; i--) {
            Station temp = new Station(outBoundStations.get(i), false);
            if (cache.contains(temp)) {
                temp = cache.get(cache.indexOf(temp));
            }

            toReturn[toReturn.length - 1 - i] = temp;
        }

        return toReturn;
    }
}
