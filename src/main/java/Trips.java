package main.java;

import java.util.Arrays;

public class Trips implements Cloneable {
    Trip[] trips;

    public Trips(Trip... trip) {
        trips = trip.clone();
    }

    public void print() {
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void sortByTime() {
        Arrays.sort(trips);
    }

    public boolean isATripBetween(int min, int max) {
        for (int i = 0; i < trips.length; i++) {
            if (trips[i].getTime() >= min || trips[i].getTime() <= max) {
                return true;
            }
        }
        return false;
    }

    public Trip[] getTrips() {
        return trips.clone();
    }
}
