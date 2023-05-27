package com.gridnine.testing.predicate.flightpredicate;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate which return true for flight where not exceed total time on the ground more than maximum time.
 * (time on the ground it's - interval between one segments arriving time and next segment departure time.)
 */
public class TotalTimeOnTheGroundLessThanMaxTime implements Predicate<Flight> {
    private Duration maxTimeOnTheGround;

    public TotalTimeOnTheGroundLessThanMaxTime( long maxTimeOnTheGround ) {
        this.maxTimeOnTheGround = Duration.ofHours(maxTimeOnTheGround);
    }

    @Override
    public boolean test( Flight flight ) {
        Duration timeOnTheGround = Duration.ZERO;
        List<Segment> segments = flight.getSegments();
        if (segments.size() < 2) {
            return true;
        } else {
            for (int i = 1; i < segments.size(); i++) {
                timeOnTheGround = timeOnTheGround.plus(Duration.between(segments.get(i - 1).getArrivalDate(),
                        segments.get(i).getDepartureDate()));
            }
            return timeOnTheGround.compareTo(maxTimeOnTheGround) < 0;
        }
    }
}
