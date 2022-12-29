package com.jpmc.theater.discounts.flatraterules;

import com.jpmc.theater.utils.LocalDateProvider;
import com.jpmc.theater.models.Showing;
import com.jpmc.theater.discounts.AbstractFlatRateDiscountRule;

import java.time.LocalDate;

public class SeventhDayOfMonthDiscount extends AbstractFlatRateDiscountRule {
	private static final double DISCOUNT = 1.0;
	private static final String DISCOUNT_NAME = "Seventh Day of Month";

	@Override
	public double getDiscount(Showing showing) {
		if (showing.getStartTime().getDayOfMonth() == 7) {
			return DISCOUNT;
		}
		return NO_DISCOUNT;
	}

	@Override
	public String getDiscountName() {
		return DISCOUNT_NAME;
	}
}
