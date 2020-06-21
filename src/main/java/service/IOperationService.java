package service;

import model.Bike;
import java.util.List;

public interface IOperationService {
    void addFoldingBike(List<Bike> bikes, Bike foldingBike);
    void writeBikesToFile(String fileName, List<Bike> bikes);
    void addEBikeOrSpeedelec(List<Bike> bikes, Bike speedelecOrEbike);
    void findBikeByBrand(List<Bike> bikes, String brand);
    void showAllBikes(List<Bike> bikes);
    List<Bike> readFile(String file);
}
