package com.company.driver;

import com.company.TrainRouteBuilder;

public class Main {

    public static void main(String[] args) {
        SimulationTicker ticker = new SimulationTicker();

        TrainRouteBuilder.createBuilder(ticker)
                .addOutboundStation("Heath")
                .addStation("Back of the Hill")
                .addStation("Riverway")
                .addStation("Mission Park")
                .addStation("Fenwood Rd")
                .addStation("Brigham Circle")
                .addStation("Longwood Medical Area")
                .addStation("Northeastern")
                .addStation("Symphony")
                .addStation("Prudential")
                .addStation("Copley")
                .addStation("Arlington")
                .addStation("Boylston")
                .addStation("Park St.")
                .addStation("Gov Center")
                .addStation("Haymarket")
                .addStation("North Station")
                .addStation("Science Park")
                .addInboundStation("Lechmere")
                .createStations();
    }
}
