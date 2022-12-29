package com.jpmc.theater.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TimeUtils {

	public static String convertToHumanReadableFormat(Duration duration) {
		long hour = duration.toHours();
		long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

		return String.format("(%s hour%s %s minute%s)", hour, getPluralPostfix(hour), remainingMin, getPluralPostfix(remainingMin));
	}

	public static String getPluralPostfix(long value) {
		if (value == 1) {
			return "";
		}
		return "s";
	}
}
