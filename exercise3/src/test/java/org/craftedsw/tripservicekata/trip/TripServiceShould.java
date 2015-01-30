package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.craftedsw.tripservicekata.user.UserBuilder.user;
import static org.mockito.Mockito.*;

public class TripServiceShould {

    public static final User PAUL = new User();
    public static final User MARTIN = new User();
    public static final Trip TRIP_TO_POZNAN = new Trip();
    public static final Trip TRIP_TO_WROCLAW = new Trip();

    private UserSession userSession;
    private TripService tripService;

    @Before
    public void setUp() {
        userSession = mock(UserSession.class);
        tripService = spy(new TripService());
        doReturn(userSession).when(tripService).userSession();
    }

    @Test(expected = UserNotLoggedInException.class)
    public void
    throw_exception_if_no_user_logged_in() {
        noUserIsLogged();

        tripService.getTripsByUser(new User());
    }

    @Test
    public void
    return_no_trips_of_user_if_it_is_not_a_friend_of_logged_in_user() {
        loggedInUserIs(PAUL);
        User stranger = user()
                .whoIsFriendOf(MARTIN)
                .andWhosTripsAre(TRIP_TO_POZNAN);
        storedAreTripsOf(stranger);

        List<Trip> trips = tripService.getTripsByUser(stranger);

        assertThat(trips).isEmpty();
    }

    @Test
    public void
    return_trips_of_user_who_is_friend_of_logged_in_user() {
        loggedInUserIs(PAUL);
        User friend = user()
                .whoIsFriendOf(MARTIN, PAUL)
                .andWhosTripsAre(TRIP_TO_POZNAN, TRIP_TO_WROCLAW);
        storedAreTripsOf(friend);

        List<Trip> trips = tripService.getTripsByUser(friend);

        assertThat(trips)
                .hasSize(2)
                .containsOnly(TRIP_TO_POZNAN, TRIP_TO_WROCLAW);
    }

    private void noUserIsLogged() {
        loggedInUserIs(null);
    }

    private void loggedInUserIs(User user) {
        when(userSession.getLoggedUser()).thenReturn(user);
    }

    private List<Trip> storedAreTripsOf(User user) {
        return doReturn(user.trips()).when(tripService).tripsOf(user);
    }

}
