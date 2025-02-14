package com.example.grocerybooking.controller;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.GroceryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/groceries")
public class UserController {
    private final GroceryService groceryService;
    
    public UserController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<Grocery> getAllAvailableGroceries() {
        return groceryService.getAllGroceries();
    }
}
