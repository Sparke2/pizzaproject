package com.rebrova.pizzaproject.service;

import com.rebrova.pizzaproject.exeption.PizzaNotFoundException;
import com.rebrova.pizzaproject.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    public Pizza savePizza(Pizza pizza);
    public List<Pizza> getAllPizza();

    public Pizza findById(int id) throws PizzaNotFoundException;
    List<Pizza> findByNameContains(String name) throws PizzaNotFoundException;
    List<Pizza> findAllByPriceDesc() throws PizzaNotFoundException;
    Pizza updatePizzaById(Integer id, Pizza pizza) throws PizzaNotFoundException;

    Optional<Pizza> deleteById(int id);

}
