package com.gridnine.testing.predicate.flightpredicate;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class DepartureTimeAfterCurrentTimeTest {
    private DepartureTimeAfterCurrentTime departureTimeAfterCurrentTime = new DepartureTimeAfterCurrentTime();

    @DataProvider
    public static Object[][] data() {
        List<Segment> segments1 = new ArrayList<>();
        List<Segment> segments2 = new ArrayList<>();

        segments1.add(new Segment(LocalDateTime.now().plusHours(2),
                LocalDateTime.now().plusHours(4)));
        Flight flightWithArrivalTimeAfterDepartureTime = new Flight(segments1);

        segments2.add(new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(6)));
        Flight flightWithArrivalTimeBeforeDepartureTime = new Flight(segments2);


        return new Object[][]{
                {flightWithArrivalTimeAfterDepartureTime, true},
                {flightWithArrivalTimeBeforeDepartureTime, false},
        };
    }

    @Test
    @UseDataProvider("data")
    public void testTest( Flight flight, boolean result ) {
        Assert.assertEquals(result, departureTimeAfterCurrentTime.test(flight));
    }

}
