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
public class ArrivalTimeAfterDepartureTimeTest {
    private ArrivalTimeAfterDepartureTime arrivalTimeAfterDepartureTime = new ArrivalTimeAfterDepartureTime();

    @DataProvider
    public static Object[][] data() {
        List<Segment> segments1 = new ArrayList<>();
        List<Segment> segments2 = new ArrayList<>();

        segments1.add(new Segment(LocalDateTime.of(2023, 05, 26, 15, 16),
                LocalDateTime.of(2023, 05, 26, 17, 16)));
        Flight flightWithArrivalTimeAfterDepartureTime = new Flight(segments1);

        segments2.add(new Segment(LocalDateTime.of(2023, 05, 26, 17, 16),
                LocalDateTime.of(2023, 05, 26, 15, 16)));
        Flight flightWithArrivalTimeBeforeDepartureTime = new Flight(segments2);


        return new Object[][]{
                {flightWithArrivalTimeAfterDepartureTime, true},
                {flightWithArrivalTimeBeforeDepartureTime, false},
        };
    }

    @Test
    @UseDataProvider("data")
    public void testTest( Flight flight, boolean result ) {
        Assert.assertEquals(result, arrivalTimeAfterDepartureTime.test(flight));
    }


}
