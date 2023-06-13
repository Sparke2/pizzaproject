package com.rebrova.pizzaproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "status")
    private String status;
    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    private List<OrderItem> items;

    public Order(Integer userId, String status, List<OrderItem> items) {
        this.userId = userId;
        this.status = status;
        this.items = items;
    }
}
