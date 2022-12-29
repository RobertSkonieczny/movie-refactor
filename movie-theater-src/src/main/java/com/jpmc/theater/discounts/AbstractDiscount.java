package com.jpmc.theater.discounts;

import com.jpmc.theater.models.Showing;

public abstract class AbstractDiscount {

	protected static final double NO_DISCOUNT = 0.0;

	public abstract double getDiscount(Showing showing);
	public abstract double getTotalCostWithDiscountApplied(double totalCost, Showing showing);
	public abstract String getDiscountName();
}
