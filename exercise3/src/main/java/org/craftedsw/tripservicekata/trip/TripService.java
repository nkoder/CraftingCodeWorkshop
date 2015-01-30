package org.craftedsw.tripservicekata.trip;

import com.google.common.annotations.VisibleForTesting;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		if (loggedInUser() == null) {
			throw new UserNotLoggedInException();
		}
		boolean isFriend = false;
		for (User friend : user.getFriends()) {
			if (friend.equals(loggedInUser())) {
				isFriend = true;
				break;
			}
		}
		if (isFriend) {
			return tripsOf(user);
		}
		return new ArrayList<Trip>();
	}

	private User loggedInUser() {
		return userSession().getLoggedUser();
	}

	@VisibleForTesting
	UserSession userSession() {
		return UserSession.getInstance();
	}

	@VisibleForTesting
	List<Trip> tripsOf(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
