package com.company;

import com.company.driver.SimulationTicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by corpa on 2/19/2016.
 */
public interface TrainRouteBuilderInterface {

    public TrainRouteBuilder addStation(String name);

    public TrainRouteBuilder addInboundStation(String name);

    public TrainRouteBuilder addOutboundStation(String name);

    public List<Station> getAllStations();

    public List<Station> buildStations();

    public Station[] buildInbound();

    public Station[] buildOutbound();

}
