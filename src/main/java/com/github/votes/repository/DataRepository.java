package com.github.votes.repository;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface DataRepository<T> {
    Sort SORT_ID = new Sort(Sort.Direction.ASC, "id");

    T get(int id);

    List<T> getAll();
}
