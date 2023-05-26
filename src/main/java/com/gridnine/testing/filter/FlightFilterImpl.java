package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Flight filter which remove all flights from the list that not pass predicate
 */
public class FlightFilterImpl implements Filter<Flight> {

    @Override
    public List<Flight> filter( List<Flight> list, Predicate<Flight>... predicate ) {
        List<Flight> flightsList = list;
        for (int i = 0; i < predicate.length; i++) {
            flightsList = flightsList.stream()
                    .filter(predicate[i])
                    .collect(Collectors.toList());
        }
        return flightsList;
    }
}
