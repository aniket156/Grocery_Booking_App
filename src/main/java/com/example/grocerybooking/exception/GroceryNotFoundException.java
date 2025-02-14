package com.example.grocerybooking.exception;

public class GroceryNotFoundException extends RuntimeException {
    public GroceryNotFoundException(String message) {
        super(message);
    }
}
