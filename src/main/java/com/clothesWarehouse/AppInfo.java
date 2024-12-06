package com.clothesWarehouse;

public class AppInfo {
    private String name;
    private String version;
    private String creationDate;
    private String developerInfo;
    private String email;

    public AppInfo(String name, String version, String creationDate, String developerInfo, String email) {
        this.name = name;
        this.version = version;
        this.creationDate = creationDate;
        this.developerInfo = developerInfo;
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("==== " + name + " ====");
        System.out.println("Version: " + version);
        System.out.println("Created on: " + creationDate);
        System.out.println("Developer: " + developerInfo);
        System.out.println("Email: " + email);
    }
}

