/*
 * Michael Masters
 * October 8, 2023.
 * Module 8 Portfolio Project
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class AutomobileInventory {
    public static void displayMenu() {
        System.out.println("********************");
        System.out.println(" 1. View Inventory.");
        System.out.println(" 2. Add Vehicle.");
        System.out.println(" 3. Update Vehicle.");
        System.out.println(" 4. Remove Vehicle.");
        System.out.println(" 5. Print to file.");
        System.out.println(" 6. Exit.");
        System.out.println("********************");
        System.out.print("Please make a selection: ");
    }
    public static Car makeCar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the make of the vehicle: ");
        String userMake = sc.next();

        System.out.println("Enter the model of the vehicle: ");
        String userModel = sc.next();

        System.out.println("Enter the color of the vehicle: ");
        String userColor = sc.next();

        System.out.println("Enter the year the vehicle was manufactured: ");
        int userYear = sc.nextInt();

        System.out.println("Enter the current mileage: ");
        int userMileage = sc.nextInt();

        Car newCar = new Car();
        newCar.setCar(userMake, userModel, userColor, userYear, userMileage);

        return newCar;
    }
    public static void displayInventory(ArrayList<Car> inventoryList) {
        if (inventoryList.isEmpty()) {
            System.out.println("There are no cars in the inventory.");
        } else {
            System.out.println("There are " + inventoryList.size() + " cars in the inventory.");
            for (int i = 0; i < inventoryList.size(); i ++){
                Car car = inventoryList.get(i);
                System.out.println("Item # " + (i + 1) + " : " + car);
            }
        }
    }
    public static void deleteCar(ArrayList<Car> inventoryList) {
            Scanner sc = new Scanner(System.in);
            displayInventory(inventoryList);
            System.out.print("Which item do you want to remove? ");
            int removeSelect = sc.nextInt();
            inventoryList.remove(removeSelect - 1);
            System.out.println("Item # " + removeSelect + " was removed from the inventory");
    }
    public static void updateCar (ArrayList<Car> inventoryList) {
        Scanner sc = new Scanner(System.in);
        displayInventory(inventoryList);
        System.out.print("Which item do you want to update? ");
        int updateSelect = sc.nextInt();
        inventoryList.remove(updateSelect - 1);

        Car newCar = makeCar();
        inventoryList.add(newCar);

        System.out.println("Item # " + updateSelect + " has been updated.");
    }
    public static void printInventoryToFile(ArrayList<Car> inventoryList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : inventoryList) {
                writer.write(car.toString());
                writer.newLine();
            }
            System.out.println("Inventory has been successfully written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> inventoryList = new ArrayList<>();
        int menuSelect;

        do {
            displayMenu();
            menuSelect = sc.nextInt();

            switch (menuSelect) {
                case 1:
                    displayInventory(inventoryList);
                    break;
                case 2:
                    Car newCar = makeCar();
                    inventoryList.add(newCar);
                    System.out.println("New car has been added to the inventory.");
                    break;
                case 3:
                    updateCar(inventoryList);
                    break;
                case 4:
                    deleteCar(inventoryList);
                    break;
                case 5:
                    printInventoryToFile(inventoryList, "vehicle_inventory.txt");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("That is not a valid menu selection.");
            }
        }
        while (menuSelect != 6);
    }
}
