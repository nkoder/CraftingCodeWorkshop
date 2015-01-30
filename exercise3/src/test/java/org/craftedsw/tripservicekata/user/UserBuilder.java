package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

class UserBuilder {

    private List<User> friends;
    private List<Trip> trips;

    public static UserBuilder user() {
        return new UserBuilder();
    }

    public UserBuilder whoIsFriendOf(User... anotherUsers) {
        this.friends = newArrayList(anotherUsers);
        return this;
    }

    public User andWhosTripsAre(Trip... trips) {
        this.trips = newArrayList(trips);
        return createUser();
    }

    private User createUser() {
        User user = new User();
        friends.forEach(user::addFriend);
        trips.forEach(user::addTrip);
        return user;
    }
}
