package com.rebrova.pizzaproject.service;

import com.rebrova.pizzaproject.exeption.PizzaNotFoundException;
import com.rebrova.pizzaproject.model.Pizza;
import com.rebrova.pizzaproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza findById(int id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isEmpty()) throw new PizzaNotFoundException(id);
        return pizza.get();
    }

    @Override
    public List<Pizza> findByNameContains(String name) throws PizzaNotFoundException {
        List<Pizza> pizzas = pizzaRepository.findByNameContains(name);
        if(pizzas.isEmpty()) throw new PizzaNotFoundException("so such pizzas");
        return pizzas;
    }

    @Override
    public List<Pizza> findAllByPriceDesc() throws PizzaNotFoundException {
        List<Pizza> pizzas = pizzaRepository.findAllByPriceDesc();
        if(pizzas.isEmpty()) throw new PizzaNotFoundException("so such pizzas");
        return pizzas;
    }

    @Override
    public Pizza updatePizzaById(Integer id, Pizza pizza) throws PizzaNotFoundException {
        Optional<Pizza> pizzaDb = pizzaRepository.findById(id);
        if(Objects.nonNull(pizzaDb.get().getDescription()) && !"".equalsIgnoreCase(pizzaDb.get().getDescription())){
            pizzaDb.get().setDescription(pizza.getDescription());
        }
        pizzaRepository.save(pizzaDb.get());
        return pizzaDb.get();
    }

    @Override
    public Optional<Pizza> deleteById(int id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);

        if (pizza.isEmpty())
            return null;

        pizzaRepository.deleteById(id);
        return Optional.of(pizza.get());
    }
}
