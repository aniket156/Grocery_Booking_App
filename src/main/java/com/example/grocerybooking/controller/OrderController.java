package com.example.grocerybooking.controller;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.entity.Order;
import com.example.grocerybooking.exception.GroceryNotFoundException;
import com.example.grocerybooking.repository.GroceryRepository;
import com.example.grocerybooking.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    private final GroceryRepository groceryRepository;

    public OrderController(OrderRepository orderRepository, GroceryRepository groceryRepository) {
        this.orderRepository = orderRepository;
        this.groceryRepository = groceryRepository;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        List<Grocery> fetchedGroceries = order.getGroceries().stream().map(g -> groceryRepository.findById(g.getId()).orElseThrow(() -> new GroceryNotFoundException("Grocery not found with id: " + g.getId()))).toList();

        order.setGroceries(fetchedGroceries);
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

}