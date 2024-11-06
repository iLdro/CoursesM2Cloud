package com.example.demo.Controller;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String plateNumber) {
        super("Car with plate number " + plateNumber + " not found.");
    }
}
