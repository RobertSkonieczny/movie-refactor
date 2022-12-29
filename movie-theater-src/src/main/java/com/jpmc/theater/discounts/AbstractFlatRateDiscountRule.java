package com.jpmc.theater.discounts;

import com.jpmc.theater.models.Showing;

public abstract class AbstractFlatRateDiscountRule extends AbstractDiscount {

	@Override
	public double getTotalCostWithDiscountApplied(double totalCost, Showing showing) {
		double discountAppliedCost = totalCost - getDiscount(showing);
		if (discountAppliedCost < 0) {
			return totalCost;
		}
		return discountAppliedCost;
	}
}
