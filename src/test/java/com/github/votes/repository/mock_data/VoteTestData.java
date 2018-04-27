package com.github.votes.repository.mock_data;

import com.github.votes.model.Vote;

import java.time.LocalDateTime;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;
import static com.github.votes.repository.mock_data.UserTestData.USER_1;
import static com.github.votes.repository.mock_data.UserTestData.USER_2;

public class VoteTestData {
    public static final int VOTE_ID_1 = START_SEQ + 28;

    public static final Vote VOTE_01 = new Vote(VOTE_ID_1, RESTAURANT_3, USER_1, LocalDateTime.of(2000,1,1,1,1));
    public static final Vote VOTE_02 = new Vote(null, RESTAURANT_2, USER_2, LocalDateTime.now());
}
