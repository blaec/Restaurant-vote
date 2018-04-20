package com.github.votes.repository.jpa;

import com.github.votes.model.Dish;
import com.github.votes.repository.DishRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class jpaDishRepository implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Dish get(int id) {
        return em.find(Dish.class, id);
    }

    @Override
    public List<Dish> getAll() {
        return em.createNamedQuery(Dish.ALL_SORTED, Dish.class).getResultList();
    }
}
