package com.jpmc.theater.discounts.flatraterules;

import com.jpmc.theater.models.Showing;
import com.jpmc.theater.discounts.AbstractFlatRateDiscountRule;

public class SecondMovieDiscount extends AbstractFlatRateDiscountRule {

	private static double DISCOUNT = 2.0;
	private static final String DISCOUNT_NAME = "Second Day of month Discount";

	@Override
	public double getDiscount(Showing showing) {
		if (showing.getSequenceOfTheDay() == 2) {
			return DISCOUNT;
		}

		return NO_DISCOUNT;
	}
	@Override
	public String getDiscountName() {
		return DISCOUNT_NAME;
	}
}
