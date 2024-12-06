package com.clothesWarehouse;

public class Validator {
    public static boolean isValidChoice(String choice) {
        return choice.matches("[1-6]");
    }

    public static boolean isValidCategory(String category) {
        return category.matches("[A-Za-z ]+");
    }

    public static boolean isValidName(String name) {
        return name.matches("[A-Za-z0-9 ]+");
    }
}

