package service;

import model.Bike;

import java.util.Scanner;

public class InterfaceForConsole {
    private boolean check = true;
    private int size = 0, numberOfGears = 0, price = 0, maxSpeed = 0;
    private String color = "", brand = "";
    private boolean lights = false;
    private long weight = 0, batteryCapacity = 0;
    private Scanner scanner = new Scanner(System.in);

    public Bike enteredParametersForAddFoldingBike() {
        while (check) {
            try {
                check = false;
                System.out.print("Enter brand bike: ");
                brand = scanner.nextLine();
                System.out.print("Enter size of the wheels: ");
                size = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number of gears: ");
                numberOfGears = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter weight: ");
                weight = Long.parseLong(scanner.nextLine());
                System.out.print("Are availability of lights at front and back(y/n): ");
                String answer = scanner.nextLine();
                while (!checkByAnswerYerOrNo(answer)){
                    answer = scanner.nextLine();
                }
                System.out.print("Enter color of bike: ");
                color = scanner.nextLine();
                System.out.print("Enter price: ");
                price = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input format");
                check = true;
            }
        }
        return new Bike(brand, size, numberOfGears, weight, lights, color, price);
    }

    public Bike enteredParametersForAddSpeedelecOrEBike() {
        while (check) {
            try {
                check = false;
                System.out.print("Enter brand bike: ");
                brand = scanner.nextLine();
                System.out.print("Enter maximum speed (in km/h)");
                maxSpeed = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter weight: ");
                weight = Long.parseLong(scanner.nextLine());
                System.out.print("Are availability of lights at front and back(y/n): ");
                String answer = scanner.nextLine();
                while (!checkByAnswerYerOrNo(answer)){
                    answer = scanner.nextLine();
                }
                System.out.print("Enter battery capacity (in mAh): ");
                batteryCapacity = Long.parseLong(scanner.nextLine());
                System.out.print("Enter color of bike: ");
                color = scanner.nextLine();
                System.out.print("Enter price: ");
                price = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input format");
                check = true;
            }
        }
        return new Bike(brand, maxSpeed, weight, lights, batteryCapacity, color, price);
    }

    public String enterBrandForFindBike() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter brand:");
        return scanner.nextLine();
    }

    private boolean checkByAnswerYerOrNo(String answer){
        if (answer.equalsIgnoreCase("y")){
            lights = true;
            return true;
        } else if (answer.equalsIgnoreCase("n")){
            lights = false;
            return true;
        }
        return false;
    }

}
