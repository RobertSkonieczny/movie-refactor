package com.jpmc.theater.discount.rules;

import com.jpmc.theater.discount.AbstractDiscountTest;
import com.jpmc.theater.discounts.flatraterules.FirstMovieDiscount;
import com.jpmc.theater.discounts.flatraterules.SecondMovieDiscount;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SecondMovieDiscountTest extends AbstractDiscountTest<SecondMovieDiscount> {

	@Test
	public void testPassingCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				2,
				LocalDateTime.now()
		);

		assertDiscountEqualTo(2.0, showing);
	}

	@Test
	public void testFailingCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				3,
				LocalDateTime.now()
		);

		assertNoDiscount(showing);
	}

	@Override
	public SecondMovieDiscount getDiscountRule() {
		return new SecondMovieDiscount();
	}
}
