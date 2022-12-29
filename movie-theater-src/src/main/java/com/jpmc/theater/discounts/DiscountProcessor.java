package com.jpmc.theater.discounts;

import com.jpmc.theater.models.Showing;
import com.jpmc.theater.discounts.flatraterules.FirstMovieDiscount;
import com.jpmc.theater.discounts.flatraterules.SecondMovieDiscount;
import com.jpmc.theater.discounts.flatraterules.SeventhDayOfMonthDiscount;
import com.jpmc.theater.discounts.percentagerules.MatineeDiscountRule;
import com.jpmc.theater.discounts.percentagerules.SpecialMovieDiscount;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DiscountProcessor {

	public static class DiscountData {

		private double totalCostWithDiscountApplied;
		private AbstractDiscount discountApplied;

		public DiscountData(double totalCostWithDiscountApplied, AbstractDiscount discountApplied) {
			this.totalCostWithDiscountApplied = totalCostWithDiscountApplied;
			this.discountApplied = discountApplied;
		}


		public double getTotalCostWithDiscountApplied() {
			return totalCostWithDiscountApplied;
		}

		public AbstractDiscount getDiscountApplied() {
			return discountApplied;
		}
	}

	/**
	 * We wouldn't need this IF we used SpringBoot. We can Autowire the Abstracts.
	 * Developers would only need to annotate the individual rules.
	 * HOWEVER if we have THOUSANDS of rules SpringContext may be VERY large and startup times can be slow.
	 * This is approach two where as if we have a large amount of rules this would be okay.
	 * Both topics can have a nice healthy debate :).
	 */
	private static final List<AbstractDiscount> ACTIVE_DISCOUNTS = Arrays.asList(
			new FirstMovieDiscount(),
			new SecondMovieDiscount(),
			new SeventhDayOfMonthDiscount(),
			new MatineeDiscountRule(),
			new SpecialMovieDiscount()
	);


	public static Optional<DiscountData> getTotalCostWithDiscount(double totalCost, Showing showing) {
		return ACTIVE_DISCOUNTS.stream()
				.map(discount -> new DiscountData(discount.getTotalCostWithDiscountApplied(totalCost, showing), discount))
				.min((d1, d2) -> (int) (d1.getTotalCostWithDiscountApplied() - d2.getTotalCostWithDiscountApplied()));
	}
}
