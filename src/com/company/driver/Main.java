package com.company.driver;

import com.company.Day;
import com.company.Station;
import com.company.TrainRouteBuilder;
import com.company.gui.SwingGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SimulationTicker ticker = new SimulationTicker();
        Day day = new Day();

        TrainRouteBuilder builder = TrainRouteBuilder.createBuilder(ticker);
        List<Station> stations = builder
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

        ticker.addTickable(new PassengerCreator(stations, day)); //This adds random passengers to the trainline

        JFrame frame = new JFrame("Train Simulator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingGUI gui = new SwingGUI(builder);
        frame.setLayout(new BorderLayout());
        frame.add(gui, "Center");
        frame.setMinimumSize(new Dimension(1024, 720));
        frame.pack();
        frame.setVisible(true);
        gui.start();

        try {
            ticker.begin(3000); //Tick every 50ms
            day.progressDay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
