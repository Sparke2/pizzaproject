package com.rebrova.pizzaproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="amount")
    private Integer amount;

    @Column(name = "total")
    private Integer total;

    @Column(name="pizzaId")
    private Integer pizzaId;

    public OrderItem(Integer amount, Integer total, Integer pizzaId) {
        this.amount = amount;
        this.total = total;
        this.pizzaId = pizzaId;
    }

    public OrderItem() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }
}
