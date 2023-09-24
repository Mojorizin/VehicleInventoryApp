/*
 * Michael Masters
 * October 8, 2023.
 * Module 8 Portfolio Project
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomobileInventory {

    List<Car> inventoryList = new ArrayList<Car>();
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
    public static void makeCar() {
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
        newCar.printCar();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuSelect = 0;

        do {
            displayMenu();
            menuSelect = sc.nextInt();

            switch (menuSelect) {
                case 1:
                    System.out.println("Option 1 needs code.");
                    break;
                case 2:
                    makeCar();
                    break;
                case 3:
                    System.out.println("You selected option 3");
                    break;
                case 4:
                    System.out.println("You selected option 4");
                    break;
                case 5:
                    System.out.println("You selected option 5");
                    break;
                case 6:
                    break;

            }
        }
        while (menuSelect != 6);
    }
}
