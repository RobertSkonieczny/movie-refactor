package com.jpmc.theater.discount;

import com.jpmc.theater.discounts.AbstractDiscount;
import com.jpmc.theater.models.Showing;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractDiscountTest<T extends AbstractDiscount> {
	protected void assertDiscountEqualTo(double expected, Showing showing) {
		assertEquals(expected, getDiscountRule().getDiscount(showing));
	}

	protected void assertNoDiscount(Showing showing) {
		assertEquals(0.0, getDiscountRule().getDiscount(showing));
	}

	public abstract T getDiscountRule();
}
