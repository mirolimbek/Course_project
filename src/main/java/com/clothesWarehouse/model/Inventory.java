package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products;

    public Inventory(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                results.add(product);
            }
        }
        return results;
    }

    public List<Product> sortByPrice() {
        return products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Product> sortByQuantity() {
        return products.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getQuantity(), p2.getQuantity()))
                .collect(Collectors.toList());
    }

}

