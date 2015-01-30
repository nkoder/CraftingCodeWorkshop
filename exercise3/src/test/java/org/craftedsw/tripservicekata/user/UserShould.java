package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserShould {

    public static final User PAUL = new User();
    public static final User MARTIN = new User();
    public static final Trip TRIP_TO_POZNAN = new Trip();
    private static final Trip TRIP_TO_WROCLAW = new Trip();

    @Test
    public void
    return_no_friends_if_he_has_none() {
        User user = new User();

        assertThat(user.getFriends()).isEmpty();
    }

    @Test
    public void
    return_his_friends() {
        User user = new User();
        user.addFriend(PAUL);
        user.addFriend(MARTIN);

        assertThat(user.getFriends())
                .hasSize(2)
                .containsOnly(PAUL, MARTIN);
    }

    @Test
    public void
    return_no_trips_if_he_was_nowhere() {
        User user = new User();

        assertThat(user.trips()).isEmpty();
    }

    @Test
    public void
    return_his_trips() {
        User user = new User();
        user.addTrip(TRIP_TO_POZNAN);
        user.addTrip(TRIP_TO_WROCLAW);

        assertThat(user.trips())
                .hasSize(2)
                .containsOnly(TRIP_TO_POZNAN, TRIP_TO_WROCLAW);
    }
}
