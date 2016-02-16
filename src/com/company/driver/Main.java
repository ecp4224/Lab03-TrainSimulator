package com.company.driver;

import com.company.Station;
import com.company.TrainRouteBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SimulationTicker ticker = new SimulationTicker();

        List<Station> stations = TrainRouteBuilder.createBuilder(ticker)
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
                .buildStations();

        ticker.addTickable(new PassengerCreator(stations)); //This adds random passengers to the trainline

        try {
            ticker.begin(50); //Tick every 50ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
