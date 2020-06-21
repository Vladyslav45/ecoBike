import model.Bike;
import service.InterfaceForConsole;
import service.OperationServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AppInterface {
    public static void run(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        boolean ischeck = true;
        OperationServiceImpl operationService = new OperationServiceImpl();
        InterfaceForConsole interfaceForConsole = new InterfaceForConsole();
        List<Bike> bikes = operationService.readFile("ecobike.txt");

        while (ischeck){
            System.out.println("Please make your choice: \n" +
                    "1 - Show the entire EcoBike catalog\n" +
                    "2 – Add a new folding bike\n" +
                    "3 – Add a new speedelec\n" +
                    "4 – Add a new e-bike\n" +
                    "5 – Find the first item of a particular brand\n" +
                    "6 – Write to file\n" +
                    "7 – Stop the program\n");
            try {
                System.out.print("Write your choice: ");
                choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){
                    case 1:
                        operationService.showAllBikes(bikes);
                        break;
                    case 2:
                        Bike foldingBike = interfaceForConsole.enteredParametersForAddFoldingBike();
                        operationService.addFoldingBike(bikes, foldingBike); break;
                    case 3:
                        Bike speedelecOrEbike = interfaceForConsole.enteredParametersForAddSpeedelecOrEBike();
                        operationService.addEBikeOrSpeedelec(bikes, speedelecOrEbike); break;
                    case 4:
                        String brand = interfaceForConsole.enterBrandForFindBike();
                        operationService.findBikeByBrand(bikes, brand); break;
                    case 5: operationService.writeBikesToFile("ecobike.txt", bikes); break;
                    case 6: ischeck = false; break;
                    default: System.out.println("Operation isn't a found"); break;
                }
            } catch (IOException e) {
                System.out.println("Not operation with this number");
            } catch (NumberFormatException ex){
                System.out.println("Incorrect input format");
            }
        }
    }
}
