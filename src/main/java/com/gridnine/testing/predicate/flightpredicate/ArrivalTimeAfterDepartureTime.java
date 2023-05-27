package com.gridnine.testing.predicate.flightpredicate;

import com.gridnine.testing.model.Flight;

import java.util.function.Predicate;

/**
 * Predicate which return true for flight where flight not contain segments with
 * arrival time after departure time.
 */
public class ArrivalTimeAfterDepartureTime implements Predicate<Flight> {
    @Override
    public boolean test( Flight flight ) {
        return flight.getSegments().stream().
                noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }
}
