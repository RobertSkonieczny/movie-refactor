package com.jpmc.theater.models;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double getTotalCost() {
        return showing.getMovieFeeWithDiscounts() * audienceCount;
    }
}