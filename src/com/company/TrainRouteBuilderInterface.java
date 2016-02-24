package com.company;

import com.company.driver.SimulationTicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by corpa on 2/19/2016.
 */
public interface TrainRouteBuilderInterface {

    /**
     * Adds a station to trainroute
     * @param name of station to add to trainroute
     * @return builder
     */
    public TrainRouteBuilder addStation(String name);

    /**
     * Adds an inbound station to trainroute
     * @param name
     * @return
     */
    public TrainRouteBuilder addInboundStation(String name);

    /**
     * Adds an outbound station to trainroute
     * @param name
     * @return
     */
    public TrainRouteBuilder addOutboundStation(String name);

    /**
     *
     * @return all stations in the list of stations
     */
    public List<Station> getAllStations();

    /**
     *
     * @return the stations built with the builder
     */
    public List<Station> buildStations();

    /**
     *
     * @return an array of inbound stations
     */
    public Station[] buildInbound();

    /**
     *
     * @return an array of outbound stations
     */
    public Station[] buildOutbound();

}
