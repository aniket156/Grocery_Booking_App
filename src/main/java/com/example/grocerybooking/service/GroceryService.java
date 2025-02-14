package com.example.grocerybooking.service;

import com.example.grocerybooking.entity.Grocery;
import com.example.grocerybooking.exception.GroceryNotFoundException;
import com.example.grocerybooking.repository.GroceryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    public void deleteGrocery(Long id) {
        groceryRepository.deleteById(id);
    }

    public Grocery updateGrocery(Long id, Grocery updatedGrocery) {
        return groceryRepository.findById(id).map(grocery -> {
            grocery.setName(updatedGrocery.getName());
            grocery.setPrice(updatedGrocery.getPrice());
            grocery.setInventory(updatedGrocery.getInventory());
            return groceryRepository.save(grocery);
        }).orElseThrow(() -> new GroceryNotFoundException("Grocery not found"));
    }

    public Grocery updateInventory(Long id, int inventory) {
        return groceryRepository.findById(id).map(grocery -> {
            grocery.setInventory(inventory);
            return groceryRepository.save(grocery);
        }).orElseThrow(() -> new GroceryNotFoundException("Grocery not found"));
    }
}