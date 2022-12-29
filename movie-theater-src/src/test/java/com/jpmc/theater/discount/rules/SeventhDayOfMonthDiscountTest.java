package com.jpmc.theater.discount.rules;


import com.jpmc.theater.discount.AbstractDiscountTest;
import com.jpmc.theater.discounts.flatraterules.SeventhDayOfMonthDiscount;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class SeventhDayOfMonthDiscountTest extends AbstractDiscountTest<SeventhDayOfMonthDiscount> {

	@Test
	public void testPassingCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				2,
				LocalDateTime.of(LocalDate.of(2021, Month.APRIL, 7), LocalTime.of(3,3,3))
		);
		assertDiscountEqualTo(1.0, showing);
	}

	@Test
	public void testNoDiscountCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				2,
				LocalDateTime.of(LocalDate.of(2021, Month.APRIL, 6), LocalTime.of(3,3,3))
		);
		assertNoDiscount(showing);
	}

	@Override
	public SeventhDayOfMonthDiscount getDiscountRule() {
		return new SeventhDayOfMonthDiscount();
	}
}
