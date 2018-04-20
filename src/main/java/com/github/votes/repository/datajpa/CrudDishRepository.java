package com.github.votes.repository.datajpa;

import com.github.votes.model.Dish;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

    @Override
    Optional<Dish> findById(Integer id);

    @Override
    List<Dish> findAll(Sort sort);
}
