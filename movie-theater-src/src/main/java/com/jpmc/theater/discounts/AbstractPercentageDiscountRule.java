package com.jpmc.theater.discounts;

import com.jpmc.theater.models.Showing;

public abstract class AbstractPercentageDiscountRule extends AbstractDiscount {
	@Override
	public double getTotalCostWithDiscountApplied(double totalCost, Showing showing) {
		return totalCost * (getDiscount(showing) / 100);
	}
}
