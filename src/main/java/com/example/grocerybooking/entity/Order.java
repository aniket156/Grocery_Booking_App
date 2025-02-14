package com.example.grocerybooking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "order_grocery", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "grocery_id"))
    private List<Grocery> groceries;

    public Order() {
    }

    public Order(Long id, List<Grocery> groceries) {
        this.id = id;
        this.groceries = groceries;
    }

    public List<Grocery> getGroceries() {
        return groceries;
    }

    public void setGroceries(List<Grocery> groceries) {
        this.groceries = groceries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

