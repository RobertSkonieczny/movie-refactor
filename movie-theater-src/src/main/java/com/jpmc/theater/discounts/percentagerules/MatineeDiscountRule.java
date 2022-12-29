package com.jpmc.theater.discounts.percentagerules;

import com.jpmc.theater.models.Showing;
import com.jpmc.theater.discounts.AbstractPercentageDiscountRule;

public class MatineeDiscountRule extends AbstractPercentageDiscountRule {

	private static final Double DISCOUNT = 25.0;

	@Override
	public double getDiscount(Showing showing) {
		if (showing.getStartTime().getHour() <= 11 && showing.getStartTime().getHour() >= 4) {
			return DISCOUNT;
		}

		return NO_DISCOUNT;
	}

	@Override
	public String getDiscountName() {
		return "Matinee Discount";
	}
}
