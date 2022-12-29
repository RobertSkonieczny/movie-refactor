package com.jpmc.theater.discounts.percentagerules;

import com.jpmc.theater.models.Showing;
import com.jpmc.theater.discounts.AbstractPercentageDiscountRule;

import java.util.Set;

public class SpecialMovieDiscount extends AbstractPercentageDiscountRule {
	private static Set<Integer> DISCOUNT_SPECIAL_APPROVED_MOVIE_CODES = Set.of(
			1
	);

	private static final String DISCOUNT_NAME = "Special Movie Discount";
	private static final Double DISCOUNT = 20.0;

	@Override
	public double getDiscount(Showing showing) {
		if (DISCOUNT_SPECIAL_APPROVED_MOVIE_CODES.contains(showing.getMovie().getMovieCode())) {
			return DISCOUNT;
		}

		return NO_DISCOUNT;
	}

	@Override
	public String getDiscountName() {
		return DISCOUNT_NAME;
	}
}
