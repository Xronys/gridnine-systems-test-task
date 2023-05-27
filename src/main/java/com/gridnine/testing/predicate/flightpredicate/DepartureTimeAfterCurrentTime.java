package com.gridnine.testing.predicate.flightpredicate;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * Predicate which return true for flight where flight not contain segments with
 * departure time before current time.
 */
public class DepartureTimeAfterCurrentTime implements Predicate<Flight> {

    @Override
    public boolean test( Flight flight ) {
        return flight.getSegments().stream().
                allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
    }

}
