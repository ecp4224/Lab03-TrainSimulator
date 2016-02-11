package com.company;

import java.util.ArrayList;
import java.util.List;

public class TrainRouteBuilder {
    private List<String> stations = new ArrayList<String>();

    private TrainRouteBuilder() { }

    public TrainRouteBuilder createBuilder() {
        return new TrainRouteBuilder();
    }

    public TrainRouteBuilder addStation(String name) {
        stations.add(name);
        return this;
    }

    public void build() {

    }

    public Station[] buildInbound() {
        
    }

    public Station[] buildOutbound() {

    }
}
