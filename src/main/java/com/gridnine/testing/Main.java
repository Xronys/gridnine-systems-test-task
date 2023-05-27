package com.gridnine.testing;


import com.gridnine.testing.factory.FlightBuilder;
import com.gridnine.testing.filter.FlightFilterImpl;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.predicate.flightpredicate.ArrivalTimeAfterDepartureTime;
import com.gridnine.testing.predicate.flightpredicate.DepartureTimeAfterCurrentTime;
import com.gridnine.testing.predicate.flightpredicate.TotalTimeOnTheGroundLessThanMaxTime;

import java.util.List;

public class Main {
    public static void main( String[] args ) {
        List<Flight> flightsList = FlightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();
        ArrivalTimeAfterDepartureTime arrivalTimeAfterDepartureTimePredicate = new ArrivalTimeAfterDepartureTime();
        DepartureTimeAfterCurrentTime departureTimeAfterCurrentTimePredicate = new DepartureTimeAfterCurrentTime();
        TotalTimeOnTheGroundLessThanMaxTime totalTimeOnTheGroundLessThanMaxTimePredicate =
                new TotalTimeOnTheGroundLessThanMaxTime(2L);

/*        System.out.println("Original test set of flight list");
        System.out.println(flightsList);

        System.out.println("Removing flights which contain segments with departure time " +
                " before current time");*/
        List<Flight> flightsListAfterDepartureTimeAfterCurrentTimePredicate =
                flightFilter.filter(flightsList, departureTimeAfterCurrentTimePredicate);
        System.out.println(flightsListAfterDepartureTimeAfterCurrentTimePredicate);

     /*   System.out.println("Removing flights which contain segments with arrival time before departure time");*/
        List<Flight> flightsListAfterArrivalTimeAfterDepartureTimePredicate =
                flightFilter.filter(flightsList, arrivalTimeAfterDepartureTimePredicate);
        System.out.println(flightsListAfterArrivalTimeAfterDepartureTimePredicate);

       /* System.out.println("Removing flights where total time on the ground more than two hours");*/
        List<Flight> flightsListAfterTotalTimeOnTheGroundLessThanMaxTimePredicate =
                flightFilter.filter(flightsList, totalTimeOnTheGroundLessThanMaxTimePredicate);
        System.out.println(flightsListAfterTotalTimeOnTheGroundLessThanMaxTimePredicate);

        //We also can use rules (predicates) together for instance
       /* flightsList = flightFilter.test(flightsList, arriveTimeAfterDepartureTimePredicate,
                departureTimeAfterCurrentTimePredicate,
                totalTimeOnTheGroundLessThanMaxTime);*/
    }
}
