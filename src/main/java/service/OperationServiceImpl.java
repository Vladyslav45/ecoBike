package service;

import model.Bike;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationServiceImpl implements IOperationService {
    @Override
    public void addFoldingBike(List<Bike> bikes, Bike foldingBike) {
        bikes.add(foldingBike);
    }

    @Override
    public void writeBikesToFile(String fileName, List<Bike> bikes) {
        try {
            BufferedWriter writeToFile = new BufferedWriter(new FileWriter(fileName));
            for (Bike bike : bikes) {
                if (bike.getBrand().startsWith("FOLDING BIKE")) {
                    writeToFile.write(bike.getBrand() + "; " + bike.getSizeOfTheWheels() + "; " + bike.getNumberOfGears() + "; " +
                            bike.getWeightOfTheBike() + "; " + bike.isAvailabilityOfLight() + "; " + bike.getColor() + "; " + bike.getPrice());
                } else {
                    writeToFile.write( bike.getBrand() + "; " + bike.getMaxSpeed() + "; " +
                            bike.getWeightOfTheBike() + "; " + bike.isAvailabilityOfLight() + "; " + bike.getBatteryCapacity() + "; " + bike.getColor() + "; " + bike.getPrice());
                }
                writeToFile.newLine();
            }
            writeToFile.close();
        } catch (IOException e) {
            System.out.println("File isn't found");
        }
    }

    @Override
    public void addEBikeOrSpeedelec(List<Bike> bikes, Bike speedelecOrEbike) {
        bikes.add(speedelecOrEbike);
    }

    @Override
    public void findBikeByBrand(List<Bike> bikes, String brand) {
            List<Bike> result = findBikes(bikes, brand);
            result.forEach(System.out::println);
    }

    protected List<Bike> findBikes(List<Bike> bikes, String brand){
        return bikes.stream()
                .filter(bike -> bike.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void showAllBikes(List<Bike> bikes) {
        bikes.forEach(bike -> System.out.println(bike.getBrand() + " with " +
                ((bike.getBrand().startsWith("FOLDING BIKE")) ? bike.getNumberOfGears() + " gear(s) and " : bike.getBatteryCapacity() + " mAh battery and ") +
                ((bike.isAvailabilityOfLight()) ? "head/tail light\n" : "no head/tail light\n") + "Price: " + bike.getPrice() + " euros"));
    }

    public List<Bike> readFile(String file) {
        List<Bike> bikesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] bikes = line.split(";");
                if (bikes[0].startsWith("FOLDING BIKE")){
                    bikesList.add(new Bike(bikes[0],Integer.parseInt(bikes[1].trim()),Integer.parseInt(bikes[2].trim()),Long.parseLong(bikes[3].trim()),Boolean.parseBoolean(bikes[4].trim()),bikes[5].trim(),Integer.parseInt(bikes[6].trim())));
                } else {
                    bikesList.add(new Bike(bikes[0], Integer.parseInt(bikes[1].trim()), Long.parseLong(bikes[2].trim()), Boolean.parseBoolean(bikes[3].trim()), Long.parseLong(bikes[4].trim()), bikes[5].trim(), Integer.parseInt(bikes[6].trim())));
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("File isn't found");
        }
        return bikesList;
    }
}
