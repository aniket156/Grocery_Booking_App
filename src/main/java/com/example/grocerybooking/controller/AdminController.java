package com.example.grocerybooking.controller;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/groceries")
public class AdminController {
    private final GroceryService groceryService;

    public AdminController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @PostMapping
    public Grocery addGrocery(@RequestBody Grocery grocery) {
        return groceryService.addGrocery(grocery);
    }

    @DeleteMapping("/{id}")
    public void deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
    }

    @PutMapping("/{id}")
    public Grocery updateGrocery(@PathVariable Long id, @RequestBody Grocery grocery) {
        return groceryService.updateGrocery(id, grocery);
    }

    @PutMapping("/{id}/inventory")
    public Grocery updateInventory(@PathVariable Long id, @RequestParam int inventory) {
        return groceryService.updateInventory(id, inventory);
    }
}
