package com.github.votes.repository;

import java.util.List;

public interface DataRepository<T> {

    T get(int id);

    List<T> getAll();
}
