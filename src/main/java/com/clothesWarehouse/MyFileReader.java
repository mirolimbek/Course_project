package com.clothesWarehouse;

import main.java.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    public static List<Product> readInventory(String filename) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String headers;
            headers = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String name = parts[1].trim();
                String category = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                int quantity = Integer.parseInt(parts[4].trim());
                String description = parts[5].trim();
                products.add(new Product(id, name, category, price, quantity, description));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return products;
    }
}
