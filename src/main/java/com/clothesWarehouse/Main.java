package com.clothesWarehouse;

import main.java.controller.WarehouseController;
import main.java.model.Inventory;
import main.java.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppInfo appInfo = new AppInfo(" Clothes/Footwears Warehouse System", "1.0", "2024-05-04", "Mirolimbek Sattorov","mirolimbek_sattorov@student.itpu.uz");
        appInfo.displayInfo();

        Inventory inventory = new Inventory(MyFileReader.readInventory("src/main/resources/clothes.csv"));
        ConsoleView view = new ConsoleView();
        WarehouseController controller = new WarehouseController(inventory, view);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.displayMenu();
            String choice = scanner.nextLine().trim();
            if (Validator.isValidChoice(choice)) {
                controller.processInput(choice, controller);
            } else {
                view.displayError("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

