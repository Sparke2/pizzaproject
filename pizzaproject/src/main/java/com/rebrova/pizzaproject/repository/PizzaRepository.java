package com.rebrova.pizzaproject.repository;

import com.rebrova.pizzaproject.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    List<Pizza> findByNameContains(String name);
    List<Pizza> findAllByPriceDesc();
}
