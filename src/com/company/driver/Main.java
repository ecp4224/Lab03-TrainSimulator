package com.company.driver;

import com.company.TrainRouteBuilder;

public class Main {

    public static void main(String[] args) {
        SimulationTicker ticker = new SimulationTicker();

        TrainRouteBuilder.createBuilder(ticker)
                .addStation("A")
                .addStation("B")
                .addStation("C")
                .addInboundStation("D")
                .addOutboundStation("E")
                .createStations();
    }
}
