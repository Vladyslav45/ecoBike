package service;

import model.Bike;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OperationServiceImplTest {

    private List<Bike> bikes;
    private OperationServiceImpl operationService = new OperationServiceImpl();

    @Before
    public void setUp(){
        bikes = new ArrayList<>();
        Bike foldingBike = new Bike("FOLDING BIKE Benetti", 24, 6, 9400, true, "silver", 1195);
        Bike speedelec = new Bike("SPEEDELEC Booster", 35, 10900, false, 13200, "green", 1279);
        Bike eBike = new Bike("E-BIKE Lankeleisi", 65, 24200, false, 10000, "black", 2399);

        bikes.add(foldingBike);
        bikes.add(speedelec);
        bikes.add(eBike);
    }

    @After
    public void clear(){
        bikes.clear();
    }

    @Test
    public void addFoldingBikeTest() {
        Bike foldingBike = new Bike("FOLDING BIKE Intertool", 24, 21, 12900, true, "coral", 1565);
        operationService.addFoldingBike(bikes, foldingBike);

        assertEquals(bikes.size(), 4);
    }

    @Test
    public void addEbikeOrSpeedelecTest() {
        Bike speedelec = new Bike("SPEEDELEC E-Scooter", 60,15300, false, 14800, "marine", 309);
        operationService.addEBikeOrSpeedelec(bikes, speedelec);
        assertEquals(bikes.size(), 4);

        Bike eBike = new Bike("E-BIKE ElectrO", 20, 19300, true, 14000, "beige", 1025);
        operationService.addEBikeOrSpeedelec(bikes, eBike);
        assertEquals(bikes.size(), 5);
    }

    @Test
    public void findBikeByBrandTest() {
        String brand = "FOLDING BIKE Benetti";
        List<Bike> res = operationService.findBikes(bikes, brand);

        assertEquals(res.size(), 1);
    }

    @Test
    public void notFindBikeByBrand() {
        String brand = "FOLDING BIKE Arms";
        List<Bike> res = operationService.findBikes(bikes, brand);

        assertEquals(res.size(), 0);
    }
}