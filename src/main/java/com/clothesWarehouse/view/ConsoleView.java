package main.java.view;

import main.java.model.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("==== Clothes/Footwears Warehouse Search System ====");
        System.out.println("1. List all products");
        System.out.println("2. Search by name");
        System.out.println("3. Search by category");
        System.out.println("4. Sort by price");
        System.out.println("5. Sort by quantity");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("==== Products ====");
            System.out.printf("%-5s | %-15s | %-10s | %-6s | %-8s | %-10s%n", "ID", "Name", "Category", "Price", "Quantity", "Description");
            System.out.println("------------------------------------------------------");
            for (Product product : products) {
                System.out.printf("%-5s | %-15s | %-10s | %-6.2f | %-8d | %-10s%n", product.getId(), product.getName(),
                        product.getCategory(), product.getPrice(), product.getQuantity(), product.getDescription());
            }
        }
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displayGoodbye() {
        System.out.println("Goodbye!");
    }
}