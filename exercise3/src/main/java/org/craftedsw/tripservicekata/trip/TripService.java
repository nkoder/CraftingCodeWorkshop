package org.craftedsw.tripservicekata.trip;

import com.google.common.annotations.VisibleForTesting;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		validateLoggedInUser();
		return user.isFriendOf(loggedInUser())
				? tripsOf(user)
				: noTrips();
	}

	private void validateLoggedInUser() {
		if (noUserIsLoggedIn()) {
			throw new UserNotLoggedInException();
		}
	}

	private boolean noUserIsLoggedIn() {
		return loggedInUser() == null;
	}

	private User loggedInUser() {
		return userSession().getLoggedUser();
	}

	@VisibleForTesting
	UserSession userSession() {
		return UserSession.getInstance();
	}

	private List<Trip> tripsOf(User user) {
		return tripDAO().findTripsOf(user);
	}

	@VisibleForTesting
	TripDAO tripDAO() {
		return new TripDAO();
	}

	private List<Trip> noTrips() {
		return newArrayList();
	}

}
