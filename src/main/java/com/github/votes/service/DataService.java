package com.github.votes.service;

import com.github.votes.util.exception.NotFoundException;

import java.util.List;

public interface DataService<T> {

    T get(int id) throws NotFoundException;

    List<T> getAll();
}
