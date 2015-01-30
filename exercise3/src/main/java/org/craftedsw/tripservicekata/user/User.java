package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class User {

	private List<Trip> trips = newArrayList();
	private List<User> friends = newArrayList();
	
	public List<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return trips;
	}

	public boolean isFriendOf(User anotherUser) {
		return getFriends().stream().anyMatch(anotherUser::equals);
	}
}
