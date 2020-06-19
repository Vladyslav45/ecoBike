package service;

import model.Bike;
import java.util.List;

public interface IOperationService {
    void addBike(List<Bike> bikes);
    void writeBikesToFile(String fileName, List<Bike> bikes);
    void addEBikeOrSpeedelec(List<Bike> bikes);
    void findBikeByBrand(List<Bike> bikes);
    void showAllBikes(List<Bike> bikes);
}
