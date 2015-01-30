package org.craftedsw.tripservicekata.trip;

import com.google.common.annotations.VisibleForTesting;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedInUser = userSession().getLoggedUser();
		boolean isFriend = false;
		if (loggedInUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedInUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripsOf(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
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
