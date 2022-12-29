package com.jpmc.theater.models;

import com.jpmc.theater.utils.TimeUtils;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public double getMovieFeeWithDiscounts() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    @Override
    public String toString() {
        return getSequenceOfTheDay() + ": " + getStartTime() + " " + getMovie().getTitle() + " " + TimeUtils.convertToHumanReadableFormat(getMovie().getRunningTime()) + " $" + getMovieFeeWithDiscounts();
    }
}
