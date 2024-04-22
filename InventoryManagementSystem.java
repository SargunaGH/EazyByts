package com.inventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            inventory.put(item, currentQuantity + quantity);
        } else {
            inventory.put(item, quantity);
        }
        System.out.println(quantity + " " + item + "(s) added to inventory.");
    }

    public void removeItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if (currentQuantity >= quantity) {
                inventory.put(item, currentQuantity - quantity);
                System.out.println(quantity + " " + item + "(s) removed from inventory.");
            } else {
                System.out.println("Insufficient quantity of " + item + " in inventory.");
            }
        } else {
            System.out.println(item + " not found in inventory.");
        }
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Display Inventory\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addItem = scanner.nextLine();
                    System.out.print("Enter quantity to add: ");
                    int addQuantity = scanner.nextInt();
                    ims.addItem(addItem, addQuantity);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String removeItem = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = scanner.nextInt();
                    ims.removeItem(removeItem, removeQuantity);
                    break;
                case 3:
                    ims.displayInventory();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
