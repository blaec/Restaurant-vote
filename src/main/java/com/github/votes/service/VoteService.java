package com.github.votes.service;

import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;

public interface VoteService {

    Vote get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Vote save(Vote vote, int userId);
}
