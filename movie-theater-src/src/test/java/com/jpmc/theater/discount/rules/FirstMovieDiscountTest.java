package com.jpmc.theater.discount.rules;

import com.jpmc.theater.discount.AbstractDiscountTest;
import com.jpmc.theater.discounts.flatraterules.FirstMovieDiscount;
import com.jpmc.theater.models.Movie;
import com.jpmc.theater.models.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FirstMovieDiscountTest extends AbstractDiscountTest<FirstMovieDiscount> {

	@Test
	public void testPassingCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				1,
				LocalDateTime.now()
		);

		assertDiscountEqualTo(3.0, showing);
	}

	@Test
	public void testFailingCase() {
		Showing showing = new Showing(
				new Movie("MOCK_CASE", Duration.of(2, ChronoUnit.MINUTES), 17.55, 0),
				2,
				LocalDateTime.now()
		);

		assertNoDiscount(showing);
	}

	@Override
	public FirstMovieDiscount getDiscountRule() {
		return new FirstMovieDiscount();
	}
}
