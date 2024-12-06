package main.java.controller;

import com.clothesWarehouse.Validator;
import main.java.model.Inventory;
import main.java.model.Product;
import main.java.view.ConsoleView;

import java.util.List;

public class WarehouseController {
    private Inventory inventory;
    private ConsoleView view;

    public WarehouseController(Inventory inventory, ConsoleView view) {
        this.inventory = inventory;
        this.view = view;
    }

    public void processInput(String choice, WarehouseController controller) {
        switch (choice) {
            case "1":
                listAllProducts();
                break;
            case "2":
                searchByName(controller);
                break;
            case "3":
                searchByCategory(controller);
                break;
            case "4":
                sortByPrice();
                break;
            case "5":
                sortByQuantity();
                break;
            case "6":
                view.displayGoodbye();
                System.exit(0);
            default:
                view.displayError("Invalid choice. Please enter a number between 1 and 6.");
        }
    }

    private void searchByName(WarehouseController controller) {
        String name = view.getInput("Enter product name: ");
        if (Validator.isValidName(name)) {
            List<Product> products = inventory.searchByName(name);
            view.displayProducts(products);
        } else {
            view.displayError("Only alphabetical symbols and digits are allowed.");
        }
    }

    private void searchByCategory(WarehouseController controller) {
        String category = view.getInput("Enter product category: ");
        if (Validator.isValidCategory(category)) {
            List<Product> products = inventory.searchByCategory(category);
            view.displayProducts(products);
        } else {
            view.displayError("Only alphabetical symbols are allowed.");
        }
    }

    private void sortByPrice() {
        List<Product> products = inventory.sortByPrice();
        view.displayProducts(products);
    }

    private void sortByQuantity() {
        List<Product> products = inventory.sortByQuantity();
        view.displayProducts(products);
    }

    private void listAllProducts() {
        view.displayProducts(inventory.getProducts());
    }
}

