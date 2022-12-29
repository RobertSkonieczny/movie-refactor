package com.jpmc.theater;

import com.jpmc.theater.models.Customer;
import com.jpmc.theater.models.Reservation;
import org.junit.jupiter.api.Test;
import com.jpmc.theater.utils.LocalDateProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.getTotalCost(), 50);
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }
}
